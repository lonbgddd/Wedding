package com.example.wedding.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.wedding.Domain.Popular;
import com.example.wedding.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }

    public void insertFood(Popular item) {

        ArrayList<Popular> listFood = getListCart();
        boolean existsAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existsAlready = true;
                n = i;
                break;
            }
        }
        if (existsAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }

        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Add yo your cart", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<Popular> getListCart() {
        return tinyDB.getListObject("CartList");
    }
    public  void minusNumberFood(ArrayList<Popular>listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }
    public void plusNumberFood(ArrayList<Popular>listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }
}



