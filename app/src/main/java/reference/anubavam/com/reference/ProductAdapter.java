package reference.anubavam.com.reference;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;
    private ProductClickListener productClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public Button add,plus,minus;
        public LinearLayout quantitylayout;
        public EditText quantityText;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            add = view.findViewById(R.id.add);
            plus = view.findViewById(R.id.plus);
            minus = view.findViewById(R.id.minus);
            quantityText = view.findViewById(R.id.quantity_text);
            quantitylayout = view.findViewById(R.id.quantitylayout);
        }
    }


    public ProductAdapter(List<Product> productList,ProductClickListener productClickListener) {
        this.productList = productList;
        this.productClickListener = productClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlayout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Product product = productList.get(position);
        final int[] quantity = {0};
        holder.title.setText(product.getTitle());
        holder.price.setText("Rs. "+product.getPrice());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add.setVisibility(View.GONE);
                holder.quantitylayout.setVisibility(View.VISIBLE);
                quantity[0] = 1;
                holder.quantityText.setText(""+ quantity[0]);
                product.setQuantity(quantity[0]);
                productClickListener.onSelectedProduct(product);
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity[0] = quantity[0] + 1;
                holder.quantityText.setText(""+ quantity[0]);
                product.setQuantity(quantity[0]);
                productClickListener.onSelectedProduct(product);
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity[0] = quantity[0] - 1;
                holder.quantityText.setText(""+ quantity[0]);
                product.setQuantity(quantity[0]);
                if(quantity[0] == 0){
                    holder.quantitylayout.setVisibility(View.GONE);
                    holder.add.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface ProductClickListener {

        void onSelectedProduct(Product product);

    }
}
