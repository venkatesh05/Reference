package reference.anubavam.com.reference;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment implements ProductAdapter.ProductClickListener{

    private List<Product> movieList = new ArrayList<>();
    private ProductAdapter mAdapter;
    private RecyclerView recyclerView;
    private int price = 0;
    private int quantity = 0;
    private int total = 0;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        mAdapter = new ProductAdapter(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        Product movie = new Product("Idly", 50, 0,"");
        movieList.add(movie);

        movie = new Product("Dosai", 80, 0,"");
        movieList.add(movie);

        movie = new Product("Masala Dosai", 100, 0,"");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSelectedProduct(Product product) {
        Log.i("Product ",""+product.getQuantity());
        quantity = product.getQuantity();
        price = product.getPrice();
        total = total + (quantity * price);
        String displayText = quantity + "Item | \u20B9 "+total;
        Snackbar snackbar = Snackbar
                .make(recyclerView, displayText, Snackbar.LENGTH_INDEFINITE)
                .setAction("View Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }
}
