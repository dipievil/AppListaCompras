package br.dipievil.applistacompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> products;
    private EditText etName, etQtd;
    private ListView lvProducts;
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();
        etName = findViewById(R.id.etName);
        etQtd = findViewById(R.id.etQtd);
        lvProducts = findViewById(R.id.lvProducts);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        lvProducts.setAdapter(adapter);
    }

    public void addItem(View view){
        // Toast.makeText(this, "Oieam", Toast.LENGTH_SHORT).show();

        String name = etName.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this, "O campo nome é obrigatório.", Toast.LENGTH_SHORT).show();
        }else{
            String quantity = etQtd.getText().toString();
            double qtd = 0.0;
            if(!quantity.isEmpty()){
                qtd = Double.valueOf(qtd);
            }
            Product prod = new Product(name,qtd);
            products.add(prod);
            adapter.notifyDataSetChanged();
        }
    }

    private void delete(int index){
        Product prod = products.get(index);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setIcon(android.R.drawable.ic_delete);
        alert.setTitle("Atenção!");
        alert.setMessage("Você deseja excluir o produto "+prod.getNome()+"?");
        alert.setNeutralButton("Cancelar", null);
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                products.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        alert.show();
    }
}