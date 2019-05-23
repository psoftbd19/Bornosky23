package com.bornosky.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bornosky.R;
import com.bornosky.adapter.DataItemAdapter;
import com.bornosky.model.StudentInfo;
import com.bornosky.sample.SampleDataProvider;
import com.bornosky.view.activity.IndividualSMS;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Diary extends Fragment {


    private Spinner spinnerSession, spinnerBranch, spinnerClass, spinnerShift, spinnerSection, spinnerMessageType;

    String[] sessionArray = {"Select session", "2018", "2019", "2020"};
    String[] branchArray = {"Select Branch", "Main", "Bashabo", "Mugda"};
    String[] classArray = {"Select class", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] shiftArray = {"Select shift", "Morning", "Day"};
    String[] sectionArray = {"Select section", "A", "B", "C"};
    String[] messageTypeArray = {"Select message type", "Bangla", "English"};
    List<StudentInfo> dataItemList = SampleDataProvider.dataItemList;
    Button btnSendSMS;

    // CheckBox checkAll;
    EditText etmessage, editSubject;
    List<String> checkedPhoneList, checkedAllPhoneList;
    String message, subject;

    public Diary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.diary, container, false);
        // setTitle("IndividualMessage");


        spinnerSession = (Spinner) root.findViewById(R.id.spinnerSession);
        spinnerBranch = (Spinner) root.findViewById(R.id.spinnerBranch);
        spinnerClass = (Spinner) root.findViewById(R.id.spinnerClass);
        spinnerShift = (Spinner) root.findViewById(R.id.spinnerShift);
        spinnerSection = (Spinner) root.findViewById(R.id.spinnerSection);
        spinnerMessageType = (Spinner) root.findViewById(R.id.spinnerMessageType);
        //checkAll = (CheckBox)root.  findViewById(R.id.checkAll);
        etmessage = (EditText) root.findViewById(R.id.etmessage);
        editSubject = (EditText) root.findViewById(R.id.editSubject);
        btnSendSMS = (Button) root.findViewById(R.id.btnSendSMS);
        checkedPhoneList = new ArrayList<>();
        checkedAllPhoneList = new ArrayList<>();


        ArrayAdapter<String> sessionAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, sessionArray);
        spinnerSession.setAdapter(sessionAdapter);


        spinnerSession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s1 = String.valueOf(spinnerSession.getSelectedItem());
                if (!s1.contentEquals("Select session")) {
                    ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, branchArray);
                    branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    branchAdapter.notifyDataSetChanged();
                    spinnerBranch.setAdapter(branchAdapter);

                    spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String s1 = String.valueOf(spinnerBranch.getSelectedItem());
                            if (!s1.contentEquals("Select Branch")) {
                                ArrayAdapter<String> classAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, classArray);
                                spinnerClass.setAdapter(classAdapter);

                                spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String s1 = String.valueOf(spinnerClass.getSelectedItem());
                                        if (!s1.contentEquals("Select class")) {
                                            ArrayAdapter<String> shiftAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, shiftArray);
                                            spinnerShift.setAdapter(shiftAdapter);

                                            spinnerShift.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    String s1 = String.valueOf(spinnerShift.getSelectedItem());
                                                    if (!s1.contentEquals("Select shift")) {
                                                        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, sectionArray);
                                                        spinnerSection.setAdapter(sectionAdapter);
                                                        spinnerSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                            @Override
                                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                String s1 = String.valueOf(spinnerSection.getSelectedItem());
                                                                if (!s1.contentEquals("Select section")) {
                                                                    ArrayAdapter<String> messageTypeAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, messageTypeArray);
                                                                    spinnerMessageType.setAdapter(messageTypeAdapter);
                                                                    spinnerMessageType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                                        @Override
                                                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                            String s1 = String.valueOf(spinnerMessageType.getSelectedItem());
                                                                            if (!s1.contentEquals("Select message type")) {
                                                                                root.findViewById(R.id.smsContainer).setVisibility(View.VISIBLE);
                                                                            } else {
                                                                                root.findViewById(R.id.smsContainer).setVisibility(View.GONE);
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onNothingSelected(AdapterView<?> parent) {

                                                                        }
                                                                    });
                                                                }
                                                            }

                                                            @Override
                                                            public void onNothingSelected(AdapterView<?> parent) {

                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else {
                    spinnerBranch.setAdapter(null);
                    spinnerClass.setAdapter(null);
                    spinnerShift.setAdapter(null);
                    spinnerSection.setAdapter(null);
                    spinnerMessageType.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DataItemAdapter adapter = new DataItemAdapter(getActivity(), dataItemList);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.rvItems);

        recyclerView.setAdapter(adapter);


//        checkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//
//                    for (int i = 0; i < dataItemList.size(); i++) {
//                        dataItemList.get(i).setChecked(true);
//                        DataItemAdapter.phones.clear();
//                        checkedAllPhoneList.add(dataItemList.get(i).getPhone());
//
//                    }
//                    DataItemAdapter adapter = new DataItemAdapter(getActivity(), dataItemList);
//                    RecyclerView recyclerView = (RecyclerView)root. findViewById(R.id.rvItems);
//                    recyclerView.setAdapter(adapter);
//                } else {
//
//                    for (int i = 0; i < dataItemList.size(); i++) {
//                        dataItemList.get(i).setChecked(false);
//                        checkedAllPhoneList.clear();
//                    }
//                    DataItemAdapter adapter = new DataItemAdapter(getActivity(), dataItemList);
//                    RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.rvItems);
//                    recyclerView.setAdapter(adapter);
//                }
//            }
//        });


        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                checkedPhoneList = DataItemAdapter.phones;
//                if (checkedPhoneList.size() > 0) {
//                    for (int i = 0; i < checkedPhoneList.size(); i++) {
//                        Toast.makeText(getActivity(), "your number " + checkedPhoneList.get(i), Toast.LENGTH_SHORT).show();
//                        SmsManager sms = SmsManager.getDefault();
//                        message = etmessage.getText().toString();
//
//                        sms.sendTextMessage(checkedPhoneList.get(i), null, message, null, null);
//
//                    }
///*
//                    String numbers[] = {"01717121839", "01766228554"};
//                    for(String number : numbers) {
//                        sms.sendTextMessage(number, null, message, null, null);
//                    }*/
//                }
//                if (checkedAllPhoneList.size() > 0) {
//                    for (int i = 0; i < checkedAllPhoneList.size(); i++) {
//                        Toast.makeText(getActivity(), "your number " + checkedAllPhoneList.get(i), Toast.LENGTH_SHORT).show();
//                        SmsManager sms = SmsManager.getDefault();
//                        message = etmessage.getText().toString();
//
//                        sms.sendTextMessage(checkedAllPhoneList.get(i), null, message, null, null);
//
//                    }
//                }

                //dataItemList
                if (dataItemList.size() > 0) {
                    for (int i = 0; i < dataItemList.size(); i++) {
                        SmsManager sms = SmsManager.getDefault();
                        message = etmessage.getText().toString();
                        subject = editSubject.getText().toString();
                        String messageBody = "("+subject + ")" + message;
                        sms.sendTextMessage(dataItemList.get(i).getPhone(), null, messageBody, null, null);
                        Toast.makeText(getActivity(), "your number " + dataItemList.get(i).getPhone(), Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        return root;
    }


}

