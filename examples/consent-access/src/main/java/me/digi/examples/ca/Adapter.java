package me.digi.examples.ca;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.VHolder> {

    final List<String> data = new ArrayList<>();

    public Adapter() {
    }

    public void setData(Map<String, String> data) {
        this.data.clear();
        this.data.addAll(data.values());
        notifyDataSetChanged();
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHolder(parent);
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        TextView textView = holder.itemView.findViewById(R.id.item);
        textView.setText(formatString(data.get(position)));
    }

    private static String formatString(String text){
        StringBuilder json = new StringBuilder();
        String indentString = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            switch (letter) {
                case '{':
                case '[':
                    json.append("\n" + indentString + letter + "\n");
                    indentString = indentString + "\t";
                    json.append(indentString);
                    break;
                case '}':
                case ']':
                    indentString = indentString.replaceFirst("\t", "");
                    json.append("\n" + indentString + letter);
                    break;
                case ',':
                    json.append(letter + "\n" + indentString);
                    break;

                default:
                    json.append(letter);
                    break;
            }
        }

        return json.toString();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VHolder extends RecyclerView.ViewHolder {

        public VHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null));
        }
    }
}
