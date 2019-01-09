/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */
package me.digi.sdk.core;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import me.digi.sdk.core.MockEntities.MockChain;
import me.digi.sdk.core.entities.CAAccounts;
import me.digi.sdk.core.internal.CAExtractContentInterceptor;
import me.digi.sdk.core.internal.Util;
import me.digi.sdk.core.provider.KeyLoaderProvider;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ExtractFileContentTest {

    private static final String GET_FILE_REQUEST_URL = "https://api.digi.me/v1/permission-access/query/xIl1TGzJwMO48k5hBbyVWSeukj62ukcc/18_1_1_2_1_D201806_1.json";
    private static final String GET_ACCOUNTS_FILE_REQUEST_URL = "https://api.digi.me/v1/permission-access/query/mGVtEptR5hHrJJeyn3md6zyrZVArIxFj/accounts.json";
    private static final String TEST_PRIVATE_KEY_FILE_NAME = "TEST_RSA_PRIVATE_KEY.p12";
    private static final String TEST_PRIVATE_KEY_PASSWORD = "digime";

    private static final String fileResponse = "{\"fileList\":[\"18_1_1_2_1_D201806_1.json\",\"18_1_1_2_1_D201807_1.json\",\"18_1_1_2_2_D201805_1.json\",\"18_1_1_2_2_D201806_1.json\",\"18_1_1_2_2_D201807_1.json\",\"18_1_1_2_7_D201806_1.json\",\"18_4_21_3_300_D201805_1.json\",\"18_4_21_3_300_D201806_1.json\",\"18_4_21_3_300_D201807_1.json\",\"18_4_21_3_300_D201808_1.json\",\"18_4_21_3_300_D201809_1.json\",\"18_4_21_3_300_D201810_1.json\",\"18_4_21_3_300_D201811_1.json\",\"18_4_21_3_301_D201805_1.json\",\"18_4_21_3_301_D201806_1.json\",\"18_4_21_3_301_D201807_1.json\",\"18_4_21_3_301_D201808_1.json\",\"18_4_21_3_301_D201809_1.json\",\"18_4_21_3_301_D201810_1.json\",\"18_4_21_3_301_D201811_1.json\",\"18_4_21_3_303_D201805_1.json\",\"18_4_21_3_303_D201806_1.json\",\"18_4_21_3_303_D201807_1.json\",\"18_4_21_3_303_D201808_1.json\",\"18_4_21_3_303_D201809_1.json\",\"18_4_21_3_303_D201810_1.json\",\"18_4_21_3_303_D201811_1.json\",\"18_5_19_1_406_D201811_1.json\"],\"fileContent\":\"Ns/qla2EfEkMQ7TdMTCIzR/VZ9Mhq93C+bl22WbdW0AggDvpdIwcDzc8Xf3MlAyUPBQ34UQWHhzaPf8mCLmiq6tTNJSDWE1dzQz2bpxelZzXzZDSnrdQzjIYi4g4VYUQUUB2sCqkEPZMj7uSfNdeFDl5qOr0Bju931LB2UWbf/kJIBKxNu4OfdRsMcmK1mvMykY3DfHg6TQiYsCs5Vp4+cPT3w7Xk/JFvGvEFehK88CI8Un+90aEGeDbW+MF0Ceu6fdZI/iNc0I7QjEzsn1hD33ctLcmqn4r4Wy9prBznloFFvavhEEI1hSBNZGnMX94CoIurHXMX3mFp9p5FcPtFqyHkG/zr419qbMvxTKQcM3uzmZFncdzE22HcF4dZt/hWyNrGgPG/rsx3eXa0HlIeax4ntozADPhVCCuczQwjnK80ov5OS9pn7RDdJPXo6M+URje5Gyu1rgyL7miMIl6d3zQTBJv40igxLk+OatXlrj62ngzrlkzVOcCAsSaB4Z/6IseawRGJ/IRVRKYlBbkIWmLiLZ42xS9QDlNbrXgW+Zec+v0bE3ywC64TU5EAIC7NWpMfmRmdRawnYVA238jV2Lo4IYwgidquQy/mRiSxxqubWzxAUst0qX42IKHR1SPTKapxRxcksFhXF9Nf318QeTC07o9ZSrbJtDpmaSOT0bF0Uf8b0FxUzLEox7n2nPfK94zRx9iJevVWoUzBw3ZCSFVBGyiPDplOl+2Ck1uvD2q3tbnQrKqfrhdRaEbF3aNjq0FR2+Cnx7iTBGhzfaeUhHxrvSpBw3hKeUswClKMb8/NmnuN9y0dhkeOovlM1OW66e85eIEbyCKFXgvoW4gWAFxFT5EeaTnU5hdoIN5OOwy9ecFJDTVDTM7J5amIC04/5pEuppLFxn1/7T49ale19O1OTaopMX0NMRVDDO9LX3jSeslU64BQLJnrmHzAOvccJX57nga+73H2g2oBZj7pkXPcniERnwO4LcR4C2echVA9JiAwnAaUM1MNbLtijPYLoQr9myKQpRrB4HNJNTT6MSapFzJP5J4T5QvUzLGQSnG5cmEHDSTZUw/tllnfyNO27eMxT7djdGMDaQi4TySFJ3zzISWLwH8bzM6HQIWxIlwhAMNenuQ2ZFDFVCI2BaSMzjlxsyEAy6EYjDAS0m0dKK8nA16Vsu021sKqGbUrfHEL+XABzyWVtca8Nol4G71zgd5m7EKNHYBbxgikYcAIFvHcpzD5ti7aQ9aysSnuYpZnAbITbETvcXNIZlgdbade2JseRRtXb+4MyUToME/GMI4HDfkO2RlqmXiJg11zRTOF6FEBPAL10jCXAY27cEbuzxpfOt26ureVAWh3UQN49k4b/I1XHmTpqYtmDywWxLVJ+o+5inOco+9cTjWHhCoA+Fe0bE3biOF7YARQeNXVPxAatOIz6NNnYPZF0BfLUgP1bvYlUHmrlWqaVfReI1OjRF+cYsidgYX6aytIwyEY3q7JzwSPARi7fCGpXShgJSqSFkZu2cV6RxR6zf1JcEgcNvjSea11wGnqsC4Ivgb5QxrLztae6cSsWdFU5PmvY+tiixy5nXq7qkbAcE3QKN1BGbsUs9SbQLwVmSn+1MqNCcFsfgXRScG9oz0OUmFStdY7LLwmwH7sEPOWXGzFaGjuZsPoInT0b5yiR+H7xfc2pd344rzAxOj71heZRIHGm3eVrPb5z1trWba/ne3KZqQ9OV4vd8utdJVwM26VkrbLYlZe80Zte/sAfBQhUiNJAD3Id7p0jy2EV8qbAdzCdDPzckQNSN12BezR1iCO3LorzRTEV9pG8rILkAntx7S9K4=\",\"compression\":\"brotli\"}";
    private static final String fileResponse_noCompression = "{\"fileList\":[\"18_1_1_2_1_D201806_1.json\",\"18_1_1_2_1_D201807_1.json\",\"18_1_1_2_2_D201805_1.json\",\"18_1_1_2_2_D201806_1.json\",\"18_1_1_2_2_D201807_1.json\",\"18_1_1_2_7_D201806_1.json\",\"18_4_21_3_300_D201805_1.json\",\"18_4_21_3_300_D201806_1.json\",\"18_4_21_3_300_D201807_1.json\",\"18_4_21_3_300_D201808_1.json\",\"18_4_21_3_300_D201809_1.json\",\"18_4_21_3_300_D201810_1.json\",\"18_4_21_3_300_D201811_1.json\",\"18_4_21_3_301_D201805_1.json\",\"18_4_21_3_301_D201806_1.json\",\"18_4_21_3_301_D201807_1.json\",\"18_4_21_3_301_D201808_1.json\",\"18_4_21_3_301_D201809_1.json\",\"18_4_21_3_301_D201810_1.json\",\"18_4_21_3_301_D201811_1.json\",\"18_4_21_3_303_D201805_1.json\",\"18_4_21_3_303_D201806_1.json\",\"18_4_21_3_303_D201807_1.json\",\"18_4_21_3_303_D201808_1.json\",\"18_4_21_3_303_D201809_1.json\",\"18_4_21_3_303_D201810_1.json\",\"18_4_21_3_303_D201811_1.json\",\"18_5_19_1_406_D201811_1.json\"],\"fileContent\":\"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\"}";
    private static final String expectedFileContent = "[{\"accountentityid\":\"1_10154943348529233\",\"type\":0,\"mediaid\":\"10156444697934233\",\"baseid\":\"10_10156444697934233\",\"cameramodelentityid\":\"\",\"commentcount\":1,\"createddate\":1529751064000,\"displayshorturl\":\"\",\"displayurlindexend\":0,\"displayurlindexstart\":0,\"entityid\":\"10_10156444697934233\",\"filter\":\"\",\"imagefileentityid\":\"\",\"imagefilerelativepath\":\"\",\"imagefileurl\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"resources\":[{\"aspectratio\":{\"accuracy\":74.98759305210918,\"actual\":\"1511:2015\",\"closest\":\"1:1\"},\"height\":2015,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"width\":1511},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":1280,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p960x960/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=1868c2cac106f5c3d52acb185b40ab30&oe=5CACAA0C\",\"width\":960},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":960,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=30beae2e3986ffb142db47b65dfdfe58&oe=5C76435F\",\"width\":720},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":800,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p600x600/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=00072910d1afa74e3d759eccff75f48f&oe=5CAC043A\",\"width\":600},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":640,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p480x480/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=8d9bc3e4245e833170ff5c431d32fdbc&oe=5C79C900\",\"width\":480},{\"aspectratio\":{\"accuracy\":74.94145199063232,\"actual\":\"320:427\",\"closest\":\"1:1\"},\"height\":427,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p320x320/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0daf36deb0379cf4701e1f1891ea50de&oe=5C70E663\",\"width\":320},{\"aspectratio\":{\"accuracy\":74.81481481481481,\"actual\":\"101:135\",\"closest\":\"1:1\"},\"height\":540,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=ff0eb776bb4f5a39b91c939da409202b&oe=5C730A28\",\"width\":404},{\"aspectratio\":{\"accuracy\":75.14450867052022,\"actual\":\"130:173\",\"closest\":\"1:1\"},\"height\":173,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p130x130/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=373173ab359d7471a32e86141375b290&oe=5CAA1284\",\"width\":130},{\"aspectratio\":{\"accuracy\":74.66666666666667,\"actual\":\"56:75\",\"closest\":\"1:1\"},\"height\":225,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p75x225/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0c9113e50d4b065f53c7f6c55fe69d76&oe=5C63F733\",\"width\":168}],\"interestscore\":0,\"itemlicenceentityid\":\"\",\"latitude\":0,\"likecount\":21,\"link\":\"https://www.facebook.com/photo.php?fbid=10156444697934233&set=a.10152228507104233&type=3\",\"locationentityid\":\"\",\"longitude\":0,\"mediaalbumname\":\"Mobile Uploads\",\"mediaobjectid\":\"10156444697934233\",\"mediaobjectlikeid\":\"\",\"name\":\"\",\"originatortype\":1,\"personentityid\":\"1_10154943348529233_10154943348529233\",\"personfilerelativepath\":\"\",\"personfileurl\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=10154943348529233&height=200&width=200&ext=1545576183&hash=AeT68K9LrOYOSVaE\",\"personfullname\":\"Hamish Maclean\",\"personusername\":\"Hamish Maclean\",\"postentityid\":\"1_10154943348529233_10154943348529233_10156444698229233\",\"tagcount\":0,\"taggedpeoplecount\":0,\"updateddate\":1529751064000}]";

    private static final String accountsFileResponse = "{\"fileList\":[\"18_1_1_2_1_D201806_1.json\",\"18_1_1_2_1_D201807_1.json\",\"18_1_1_2_2_D201806_1.json\",\"18_1_1_2_2_D201807_1.json\",\"18_1_1_2_7_D201806_1.json\",\"18_1_4_1_1_D201806_1.json\",\"18_1_4_1_1_D201807_1.json\",\"18_1_4_1_1_D201808_1.json\",\"18_1_4_1_1_D201809_1.json\",\"18_1_4_1_1_D201810_1.json\",\"18_1_4_1_1_D201812_1.json\",\"18_1_4_1_2_D201806_1.json\",\"18_1_4_1_2_D201807_1.json\",\"18_1_4_1_2_D201808_1.json\",\"18_1_4_1_2_D201809_1.json\",\"18_1_4_1_2_D201810_1.json\",\"18_1_4_1_2_D201812_1.json\",\"18_1_4_1_7_D201807_1.json\",\"18_1_4_1_7_D201809_1.json\"],\"fileContent\":\"GDutkmDRabcuJbgORfST5kcmWl6h/3hpt3D2o3qAYyZnPH0sV/Svt34gEcQZfN0DObjcyHOkR3VX6thk1bOjs/xR6GQuPzt4QoViGAFLMYeSLH8Re52vVPXS8KxpAIolqVtoNknczyqqQEpAQSTjrKc0+Wrdx/UfkMgIjAL+lEP+uFpV6kNGNBhglqPjWnSVUSM5Qu/RFyWD3sJkDiUT1TfuiG9yl39e36MdLLhFrTYRxTtJt5hAbtHrFqI4Qjs4PrfKBc7EZHZ1ku8ekripuk7oqX77ElPnj+Xu5k3F/SNA6A7EewBBKOonD8/2vLr9sUqjqZCgE3W9EVjn9X4TcfO3QnpSfYn99VI5cv7IRZZEXkHGDvWQTYeBeFIryG3NXXP0hnWzeMI1WskzHryL6lH5N08WsgfWPpIuiv0+EuweWsXotEukWV5ONTmHcNROKzJ4kOuewXpdk9icKp5OETB071CgV+m4g53/YMquvn2bTfc9oUUnpnjDdGO3l/bumJYUijScJ157Odvh16Aj5BM9YaXP3dUUek1th0pAbSFGdpX49lzFnsF28otm7w02c9t2N2v1cR+DQz9oXY7PEpMYbhb3RS4wdKpjsHYPcnsgRdYRDPK8PI6SeMsiJSh4Nka25MOMBZ4DTI3zeSXCFm5N0yI904JCKqiY24Qc9lo+VQatkknTVypbRc+NVcyy0TQd5Gp/GFd3n04NQw5iZ1SrzMOFfvlGMOZ2wF793zw=\"}";
    private static final String expectedFileContent_CAAccounts = "{\"accounts\":[{\"id\":\"1_10154943348529233\",\"name\":\"Hamish Maclean\",\"service\":{\"name\":\"Facebook\"}},{\"id\":\"4_3877059240\",\"name\":\"hammyalexmac\",\"service\":{\"name\":\"Instagram\"}}],\"consentid\":\"25fb20b4ddc99b0515ab3747cd7cc59e\"}";

    private static final String fileResponse2_unencrypted = "{\"fileList\":[\"18_1_1_2_1_D201806_0.json\",\"18_1_1_2_1_D201807_0.json\",\"18_1_1_2_2_D201806_0.json\",\"18_1_1_2_2_D201807_0.json\",\"18_1_1_2_7_D201806_0.json\"],\"fileContent\":[{\"accountentityid\":\"1_10154943348529233\",\"type\":0,\"mediaid\":\"10156444697934233\",\"baseid\":\"10_10156444697934233\",\"cameramodelentityid\":\"\",\"commentcount\":1,\"createddate\":1529751064000,\"displayshorturl\":\"\",\"displayurlindexend\":0,\"displayurlindexstart\":0,\"entityid\":\"10_10156444697934233\",\"filter\":\"\",\"imagefileentityid\":\"\",\"imagefilerelativepath\":\"\",\"imagefileurl\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"resources\":[{\"aspectratio\":{\"accuracy\":74.98759305210918,\"actual\":\"1511:2015\",\"closest\":\"1:1\"},\"height\":2015,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"width\":1511},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":1280,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p960x960/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=c33743ad72a75c4b1fdf0959602ce4fe&oe=5C851D0C\",\"width\":960},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":960,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=30beae2e3986ffb142db47b65dfdfe58&oe=5C76435F\",\"width\":720},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":800,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p600x600/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=582638ac5645254704563ab53fe04812&oe=5C84773A\",\"width\":600},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":640,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p480x480/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=8d9bc3e4245e833170ff5c431d32fdbc&oe=5C79C900\",\"width\":480},{\"aspectratio\":{\"accuracy\":74.94145199063232,\"actual\":\"320:427\",\"closest\":\"1:1\"},\"height\":427,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p320x320/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0daf36deb0379cf4701e1f1891ea50de&oe=5C70E663\",\"width\":320},{\"aspectratio\":{\"accuracy\":74.81481481481481,\"actual\":\"101:135\",\"closest\":\"1:1\"},\"height\":540,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=ff0eb776bb4f5a39b91c939da409202b&oe=5C730A28\",\"width\":404},{\"aspectratio\":{\"accuracy\":75.14450867052022,\"actual\":\"130:173\",\"closest\":\"1:1\"},\"height\":173,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p130x130/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=30161175590f0188f85f55da333e6a4b&oe=5C828584\",\"width\":130},{\"aspectratio\":{\"accuracy\":74.66666666666667,\"actual\":\"56:75\",\"closest\":\"1:1\"},\"height\":225,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p75x225/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0c9113e50d4b065f53c7f6c55fe69d76&oe=5C63F733\",\"width\":168}],\"interestscore\":0,\"itemlicenceentityid\":\"\",\"latitude\":0,\"likecount\":21,\"link\":\"https://www.facebook.com/photo.php?fbid=10156444697934233&set=a.10152228507104233&type=3\",\"locationentityid\":\"\",\"longitude\":0,\"mediaalbumname\":\"Mobile Uploads\",\"mediaobjectid\":\"10156444697934233\",\"mediaobjectlikeid\":\"\",\"name\":\"\",\"originatortype\":1,\"personentityid\":\"1_10154943348529233_10154943348529233\",\"personfilerelativepath\":\"\",\"personfileurl\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=10154943348529233&height=200&width=200&ext=1544978735&hash=AeSns_oDAGTLLBNn\",\"personfullname\":\"Hamish Maclean\",\"personusername\":\"Hamish Maclean\",\"postentityid\":\"1_10154943348529233_10154943348529233_10156444698229233\",\"tagcount\":0,\"taggedpeoplecount\":0,\"updateddate\":1529751064000}]}";
    private static final String expectedFileContent2 = "[{\"accountentityid\":\"1_10154943348529233\",\"type\":0,\"mediaid\":\"10156444697934233\",\"baseid\":\"10_10156444697934233\",\"cameramodelentityid\":\"\",\"commentcount\":1,\"createddate\":1529751064000,\"displayshorturl\":\"\",\"displayurlindexend\":0,\"displayurlindexstart\":0,\"entityid\":\"10_10156444697934233\",\"filter\":\"\",\"imagefileentityid\":\"\",\"imagefilerelativepath\":\"\",\"imagefileurl\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"resources\":[{\"aspectratio\":{\"accuracy\":74.98759305210918,\"actual\":\"1511:2015\",\"closest\":\"1:1\"},\"height\":2015,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=e02d9dfe0f50e76315cce2553926e182&oe=5C67FCF5\",\"width\":1511},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":1280,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p960x960/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=c33743ad72a75c4b1fdf0959602ce4fe&oe=5C851D0C\",\"width\":960},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":960,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=30beae2e3986ffb142db47b65dfdfe58&oe=5C76435F\",\"width\":720},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":800,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p600x600/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=582638ac5645254704563ab53fe04812&oe=5C84773A\",\"width\":600},{\"aspectratio\":{\"accuracy\":75,\"actual\":\"3:4\",\"closest\":\"1:1\"},\"height\":640,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p480x480/35924285_10156444697944233_1789097832926412800_o.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=8d9bc3e4245e833170ff5c431d32fdbc&oe=5C79C900\",\"width\":480},{\"aspectratio\":{\"accuracy\":74.94145199063232,\"actual\":\"320:427\",\"closest\":\"1:1\"},\"height\":427,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p320x320/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0daf36deb0379cf4701e1f1891ea50de&oe=5C70E663\",\"width\":320},{\"aspectratio\":{\"accuracy\":74.81481481481481,\"actual\":\"101:135\",\"closest\":\"1:1\"},\"height\":540,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p180x540/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=ff0eb776bb4f5a39b91c939da409202b&oe=5C730A28\",\"width\":404},{\"aspectratio\":{\"accuracy\":75.14450867052022,\"actual\":\"130:173\",\"closest\":\"1:1\"},\"height\":173,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p130x130/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=30161175590f0188f85f55da333e6a4b&oe=5C828584\",\"width\":130},{\"aspectratio\":{\"accuracy\":74.66666666666667,\"actual\":\"56:75\",\"closest\":\"1:1\"},\"height\":225,\"mimetype\":\"image/jpeg\",\"resize\":\"fit\",\"type\":0,\"url\":\"https://scontent.xx.fbcdn.net/v/t1.0-0/p75x225/36033433_10156444697939233_835298996506329088_n.jpg?_nc_cat=111&_nc_ht=scontent.xx&oh=0c9113e50d4b065f53c7f6c55fe69d76&oe=5C63F733\",\"width\":168}],\"interestscore\":0,\"itemlicenceentityid\":\"\",\"latitude\":0,\"likecount\":21,\"link\":\"https://www.facebook.com/photo.php?fbid=10156444697934233&set=a.10152228507104233&type=3\",\"locationentityid\":\"\",\"longitude\":0,\"mediaalbumname\":\"Mobile Uploads\",\"mediaobjectid\":\"10156444697934233\",\"mediaobjectlikeid\":\"\",\"name\":\"\",\"originatortype\":1,\"personentityid\":\"1_10154943348529233_10154943348529233\",\"personfilerelativepath\":\"\",\"personfileurl\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=10154943348529233&height=200&width=200&ext=1544978735&hash=AeSns_oDAGTLLBNn\",\"personfullname\":\"Hamish Maclean\",\"personusername\":\"Hamish Maclean\",\"postentityid\":\"1_10154943348529233_10154943348529233_10156444698229233\",\"tagcount\":0,\"taggedpeoplecount\":0,\"updateddate\":1529751064000}]";

    private static final String accountsFileResponse2_unencrypted = "{\"fileList\":[\"18_1_1_2_1_D201806_0.json\",\"18_1_1_2_1_D201807_0.json\",\"18_1_1_2_2_D201806_0.json\",\"18_1_1_2_2_D201807_0.json\",\"18_1_1_2_7_D201806_0.json\"],\"fileContent\":{\"accounts\":[{\"id\":\"1_10154943348529233\",\"name\":\"Hamish Maclean\",\"service\":{\"name\":\"Facebook\"}}],\"consentid\":\"c68667015658ae2af00d43c7a62af409\"}}";
    private static final String expectedFileContent2_CAAccounts = "{\"accounts\":[{\"id\":\"1_10154943348529233\",\"name\":\"Hamish Maclean\",\"service\":{\"name\":\"Facebook\"}}],\"consentid\":\"c68667015658ae2af00d43c7a62af409\"}";

    private static final String sampleData1 = "[{\"accesstoken\": \"\",\"accountid\": \"123456789\",\"accounttype\": 0,\"connectionstatus\": 2,\"createddate\": 1542633371920,\"entityid\": \"1_123456789\",\"fileurl\": \"\",\"fullname\": \"Test test\",\"jfsid\": 1,\"profileurl\": \"\",\"servicegroupid\": 1,\"serviceid\": 1,\"updateddate\": 1542633554588,\"username\": \"Test test\"}]";
    private static final String sampleData2 = "{\"version\": \"2.0.0\",\"data\": [{ \"atlasmapversion\": \"1.0.0\", \"objecttypeversion\": \"2.0.0\", \"objects\": [{ \"createddate\": 1446929710000, \"asserteddate\": 1446929710000, \"verificationstatus\": \"confirmed\", \"criticality\": \"CRITL\", \"entityid\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB_TPcWiBG2h2E114Vh0sRT8fQB\", \"id\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB_TPcWiBG2h2E114Vh0sRT8fQB\", \"onsetdatetime\": 1272758400000, \"recorder\": { \"display\": \"MOORE, SEAN\", \"reference\": \"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/TItWfhjChtlo0pFh9nzctSQB\" },\"note\": [],\"code\": { \"text\": \"SHELLFISH-DERIVED PRODUCTS\", \"coding\": [{ \"system\": \"http://hl7.org/fhir/ndfrt\", \"code\": \"N0000007624\", \"display\": \"SHELLFISH-DERIVED PRODUCTS\" }]},\"reaction\": [{ \"manifestation\": [{ \"text\": \"Itching\" }],\"note\": [{ \"text\": \"\" }],\"onset\": 1272758400000, \"substance\": { \"text\": \"SHELLFISH-DERIVED PRODUCTS\", \"coding\": [{ \"system\": \"http://hl7.org/fhir/ndfrt\", \"code\": \"N0000007624\", \"display\": \"SHELLFISH-DERIVED PRODUCTS\" }]} }],\"accountentityid\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\" },{ \"createddate\": 1446929794000, \"asserteddate\": 1446929794000, \"verificationstatus\": \"confirmed\", \"criticality\": \"CRITH\", \"entityid\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB_TKebKfLXzu6Sp.LY-IpvpmQB\", \"id\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB_TKebKfLXzu6Sp.LY-IpvpmQB\", \"onsetdatetime\": 1394150400000, \"recorder\": { \"display\": \"MOORE, SEAN\", \"reference\": \"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/TItWfhjChtlo0pFh9nzctSQB\" },\"note\": [],\"code\": { \"text\": \"STRAWBERRY\", \"coding\": [{ \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"code\": \"892484\", \"display\": \"STRAWBERRY\" },{ \"system\": \"http://fdasis.nlm.nih.gov\", \"code\": \"4J2TY8Y81V\", \"display\": \"STRAWBERRY\" }]},\"reaction\": [{ \"manifestation\": [{ \"text\": \"Anaphylaxis\" }],\"note\": [{ \"text\": \"\" }],\"onset\": 1394150400000, \"substance\": { \"text\": \"STRAWBERRY\", \"coding\": [{ \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"code\": \"892484\", \"display\": \"STRAWBERRY\" },{ \"system\": \"http://fdasis.nlm.nih.gov\", \"code\": \"4J2TY8Y81V\", \"display\": \"STRAWBERRY\" }]} }],\"accountentityid\": \"20_Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\" }]}],\"descriptor\": { \"accountjfsid\": 1, \"dateshard\": \"D201511\", \"dateshardmode\": \"D\", \"objecttype\": 127, \"servicegroup\": 2, \"servicetype\": 20, \"hash\": \"23f9c4f7601ae50a1ddff9c8add6cd61\", \"atlasmapversions\": [{ \"version\": \"1.0.0\", \"count\": 2 }],\"objecttypeversions\": [{ \"version\": \"2.0.0\", \"count\": 2 }],\"updateddate\": 1540457538891, \"createddate\": 1540457538891}}";
    // base64 encoded
    private static final String brotliCompressedData1 = "G78BAMT3m9N3m/D/RZfY6DngXIlyG687QD74/wvcDnLKslNbYGWBZTkW2Jdu8xFED79NcfxV1W5jAMA3HADozvoXMjTcUw4iE/9x0L1Ud8pBnh+EUZykGe0g75Eph5t8YOO+GvpFLqIXyuFX/swX4fv9Ikw5vCj04yAIEi/zRxXcSyXvPTpOvq+qlvXcishVum37S8eUg7a8CIQXYWmtFomNB0yN8zBV3nmTH7wGzcQIwIEe73qBKAqjNF3oheed0ey/MQ4=";
    private static final String brotliCompressedData2 = "G3YJAMTKpr6+mX3LIOSun0tPBdKKLIkgjymDLulMXA7oGcas0Maalo61bQ7NOo+zqMt4TLBNES20BCjGbK7ps/VMDARRb2tJS/2HuG9ngYQIeMDBYBQpyMc/KDoqX6i6GhAtUe0PVhP91JYOFnzPhbWF+V2yxiiykFGvNxiL8TDinHMG5b1tzjgD/YHlSdGHh4Suysw1hTVg0I0jp9XR0Q8kZvEmPQWDLcnRjzOQEPw13VN39zG759P+ZdJsP2cf4tC5PO4C5db+Q3xfH67PRvvb2tJdNX1NL/Wtm65ELhZR1LvJuY/TUXY1BQPTuavSWzKKLLnCQkZiKIb9UY8bwNRYvWv/MOQfQkPOhsTZxUW8YCfJYnIOhv3hz2FLbSGRE9VehmFV27LjdGBrp/9oQMhyvYlDVbuL33mepNcivGyUJkeuKm0Tphu6zfLDLKdjxetlPi5/NSVXU7QMZUUW8vGZQVfGQv6B7DdBIlkvTk+Xm2TdmS/izc1ifnIZX8yvZ2kCBl0ZV75DPv7B/3iyBSRyolqGYX4cBlXzHma5a8LSZA2BQVfGQuKcc845Hw5ED0zxEhN51va5ZXgFiy408SMAeimz1VM2pHNXvqN9Vo2tEZ1A75PEfeHkP/aelJ3fjQEs7TPDW0rZcv1O0LKhSuu4x6yQ6Yzr+jTb2f0uO737/RgkdXB639nUn3WRUmSaMH+J3XEv6vM0iTSe3E4XcXzvnQt8fX0F5bEISpcH79Vn2NjooEuFH8XRh813WTWFv44ajUVv5Koxwsq0TMaYzCjv/BHDcct6W5Hej+5H0Q3XDI30XZyUqs5/jurb+dGeoDuT54/Ahk8xWXg8t88MJpiOvqbK9Zmsgw6ZdwYywg/HW5+rxkBiLnjUjyJQBIUhxHOoYKCfeg1UMwRMZX8KsxlSFDKqPVbBGXLlc0iIbjbWvWw44JGyfa4iY7JsrEfKmIE2gwgMvTAASQxcYUEZugJ6SLEMsNuUyo1wovGjNhhnff0e7/WH/e5oNI7YxBpHl7Ut";

    private CAExtractContentInterceptor extractContentInterceptor;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getContext();
        KeyLoaderProvider keyLoader = new KeyLoaderProvider();
        keyLoader.getStore().addPKCS12KeyFromAssets(context, TEST_PRIVATE_KEY_FILE_NAME, null, TEST_PRIVATE_KEY_PASSWORD, null);
        extractContentInterceptor = new CAExtractContentInterceptor(keyLoader.getStore());
    }

    @Test
    public void extract_encrypted_and_compressed_file_content() throws IOException {
        Interceptor.Chain chain = new MockChain(GET_FILE_REQUEST_URL, responseFromBody(fileResponse));
        String fileContent = fileContentFromChain(chain);

        assertEquals(Util.removeNewLinesAndSpaces(expectedFileContent), Util.removeNewLinesAndSpaces(fileContent));
    }

    @Test
    public void extract_encrypted_but_not_compressed_file_content() throws IOException {
        Interceptor.Chain chain = new MockChain(GET_FILE_REQUEST_URL, responseFromBody(fileResponse_noCompression));
        String fileContent = fileContentFromChain(chain);

        assertEquals(Util.removeNewLinesAndSpaces(expectedFileContent), Util.removeNewLinesAndSpaces(fileContent));
    }

    @Test
    public void extract_unencrypted_and_not_compressed_file_content() throws IOException {
        Interceptor.Chain chain = new MockChain(GET_FILE_REQUEST_URL, responseFromBody(fileResponse2_unencrypted));
        String fileContent = fileContentFromChain(chain);

        assertEquals(Util.removeNewLinesAndSpaces(expectedFileContent2), Util.removeNewLinesAndSpaces(fileContent));
    }

    @Test
    public void extract_encrypted_and_compressed_account_file_content() throws IOException {
        Interceptor.Chain chain = new MockChain(GET_ACCOUNTS_FILE_REQUEST_URL, responseFromBody(accountsFileResponse));
        // accounts file request should automatically strip the fileContent already
        String responseBody = responseBodyFromChain(chain);

        assertEquals(Util.removeNewLinesAndSpaces(expectedFileContent_CAAccounts), Util.removeNewLinesAndSpaces(responseBody));
        CAAccounts caAccounts = new Gson().fromJson(responseBody, CAAccounts.class);
        assertTrue(caAccounts.accounts.size() == 2);
    }

    @Test
    public void extract_unencrypted_and_not_compressed_account_file_content() throws IOException {
        Interceptor.Chain chain = new MockChain(GET_ACCOUNTS_FILE_REQUEST_URL, responseFromBody(accountsFileResponse2_unencrypted));
        // accounts file request should automatically strip the fileContent already
        String responseBody = responseBodyFromChain(chain);

        assertEquals(Util.removeNewLinesAndSpaces(expectedFileContent2_CAAccounts), Util.removeNewLinesAndSpaces(responseBody));
        CAAccounts caAccounts = new Gson().fromJson(responseBody, CAAccounts.class);
        assertTrue(caAccounts.accounts.size() == 1);
        assertTrue(caAccounts.accounts.get(0).service.name.equals("Facebook"));
    }

    private String fileContentFromChain(Interceptor.Chain chain) throws IOException {
        Response response = extractContentInterceptor.intercept(chain);
        JsonObject jsonObject = new Gson().fromJson(response.body().string(), JsonObject.class);
        return jsonObject.get("fileContent").toString();
    }

    private String responseBodyFromChain(Interceptor.Chain chain) throws IOException {
        return extractContentInterceptor.intercept(chain).body().string();
    }

    private Response responseFromBody(String body) {
        return new Response.Builder()
            .body(ResponseBody.create(MediaType.parse("application/json"), body))
            .code(200)
            .message("empty message")
            .request(new Request.Builder().url(GET_FILE_REQUEST_URL).build())
            .protocol(Protocol.HTTP_1_1)
            .build();
    }

    @Test
    public void brotli_decompression() throws IOException {
        String decompressed1 = extractContentInterceptor.decompressBrotli(Base64.decode(brotliCompressedData1.getBytes("UTF-8"), Base64.DEFAULT));
        String decompressed2 = extractContentInterceptor.decompressBrotli(Base64.decode(brotliCompressedData2.getBytes("UTF-8"), Base64.DEFAULT));

        assertEquals(Util.removeNewLinesAndSpaces(decompressed1), Util.removeNewLinesAndSpaces(sampleData1));
        assertEquals(Util.removeNewLinesAndSpaces(decompressed2), Util.removeNewLinesAndSpaces(sampleData2));
    }

   /* @Test
    public void gzip_decompression() throws IOException {
        String decompressed1 = extractContentInterceptor.decompressGZIP(Base64.decode(brotliCompressedData1.getBytes("UTF-8"), Base64.DEFAULT));
        String decompressed2 = extractContentInterceptor.decompressGZIP(Base64.decode(brotliCompressedData2.getBytes("UTF-8"), Base64.DEFAULT));

        assertEquals(Util.removeNewLinesAndSpaces(decompressed1), Util.removeNewLinesAndSpaces(sampleData1));
        assertEquals(Util.removeNewLinesAndSpaces(decompressed2), Util.removeNewLinesAndSpaces(sampleData2));
    }*/

}