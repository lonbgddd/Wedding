package com.example.wedding.fragmnet;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.wedding.BaseFragment;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentContactBinding;

import java.util.Calendar;

public class ContactFragment extends BaseFragment {
    private FragmentContactBinding binding = null;
    private int lastSelectedYear;
    private int lastSelectedMonth;
    private int lastSelectedDayOfMonth;


    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Calendar c = Calendar.getInstance();
        this.lastSelectedYear = c.get(Calendar.YEAR);
        this.lastSelectedMonth = c.get(Calendar.MONTH);
        this.lastSelectedDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContactBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void listening() {
        binding.edtTuvan.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    binding.edtTuvan.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    lastSelectedYear = year;
                    lastSelectedMonth = monthOfYear;
                    lastSelectedDayOfMonth = dayOfMonth;
                }
            };
            DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), dateSetListener, lastSelectedYear, lastSelectedMonth,
                    lastSelectedDayOfMonth);
            datePickerDialog.show();
        });
        binding.btnSubmit.setOnClickListener(v -> {
            if (validate()){
                Toast.makeText(requireContext(), "Gửi liên hệ thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    Boolean validate() {
         if (binding.edtName.getText().toString().isEmpty()) {
            binding.edtName.setError("Bạn chưa nhập Email");
            binding.edtName.requestFocus();
            return false;
        }
         else if (binding.edtSdt.getText().toString().isEmpty()) {
             binding.edtSdt.setError("Bạn chưa nhập số điện thoại");
             binding.edtSdt.requestFocus();
             return false;
         } else if (binding.edtEmail.getText().toString().isEmpty()) {
             binding.edtEmail.setError("Bạn chưa nhập Email");
             binding.edtEmail.requestFocus();
             return false;
         }else if (binding.edtTuvan.getText().toString().isEmpty()) {
             binding.edtTuvan.setError("Bạn chưa nhập chọn ngày");
             binding.edtTuvan.requestFocus();
             return false;
         }


        return true;
    }

}