package br.dipievil.applistacompras;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private List<Product> listProducts;
    private Context context;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> listProducts){
        this.context = context;
        this.listProducts = listProducts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Object getItem(int index) {
        return listProducts.get(index);
    }

    @Override
    public long getItemId(int index) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemSupport item;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, null);
            item = new ItemSupport();
            item.tvName = view.findViewById(R.id.tvProdName);
            item.tvQtd = view.findViewById(R.id.tvProdQtd);
            item.layout = view.findViewById(R.id.llProd);
            view.setTag(item);
        } else {
            item = (ItemSupport) view.getTag();
        }

        Product product = listProducts.get(i);
        item.tvName.setText(product.getNome());
        item.tvQtd.setText(String.valueOf(product.getQtd()));

        if(i%2==0){
            item.layout.setBackgroundColor(Color.LTGRAY);
        }

        return view;
    }

    private class ItemSupport{
        TextView tvName, tvQtd;
        LinearLayout layout;
    }
}
