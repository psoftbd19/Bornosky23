package com.bornosky.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bornosky.R;
import com.bornosky.view.activity.AbsentMessage;
import com.bornosky.view.activity.BirthDayMessage;
import com.bornosky.view.activity.GoverningBody;
import com.bornosky.view.activity.IndividualSMS;
import com.bornosky.view.activity.IndividualMessageWithName;
import com.bornosky.view.activity.ManagingCommittee;
import com.bornosky.view.activity.OfficeStaffSMS;
import com.bornosky.view.activity.SMSAllBranches;
import com.bornosky.view.activity.SMSForAllClass;
import com.bornosky.view.activity.SMSForAllShift;
import com.bornosky.view.activity.SMSForAllStudent;
import com.bornosky.view.activity.TeacherMessage;

/**
 * A simple {@link Fragment} subclass.
 */
public class Message extends Fragment implements View.OnClickListener {


    public Message() {
        // Required empty public constructor
    }

    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sms, container, false);
        view.findViewById(R.id.btnIndividualSMS).setOnClickListener(this);
        view.findViewById(R.id.btnSmsWithName).setOnClickListener(this);
        view.findViewById(R.id.btnAbsentSMS).setOnClickListener(this);
        view.findViewById(R.id.buttonAbsentMessage).setOnClickListener(this);
        view.findViewById(R.id.btnTeachersSMS).setOnClickListener(this);
        view.findViewById(R.id.btnSMSForAllStudents).setOnClickListener(this);
        view.findViewById(R.id.buttonSMSForAllShift).setOnClickListener(this);
        view.findViewById(R.id.buttonOfficeStaffSMS).setOnClickListener(this);
        view.findViewById(R.id.buttonBirthDayMessage).setOnClickListener(this);
        view.findViewById(R.id.buttonSetBirthDayMessage).setOnClickListener(this);
        view.findViewById(R.id.buttonSMSAllClass).setOnClickListener(this);
        view.findViewById(R.id.buttonSmsBranches).setOnClickListener(this);
        view.findViewById(R.id.buttonManagingCommittee).setOnClickListener(this);
        view.findViewById(R.id.buttonGovernBody).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btnIndividualSMS:
                startActivity(new Intent(mContext, IndividualSMS.class));
                break;
            case R.id.btnSmsWithName:
                startActivity(new Intent(mContext, IndividualMessageWithName.class));
                break;
            case R.id.btnAbsentSMS:
                startActivity(new Intent(mContext, AbsentMessage.class));
                break;
            case R.id.buttonAbsentMessage:
                Toast.makeText(mContext, "I have no idea!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTeachersSMS:
                startActivity(new Intent(mContext, TeacherMessage.class));
                break;
            case R.id.btnSMSForAllStudents:
                startActivity(new Intent(getActivity(), SMSForAllStudent.class));
                break;
            case R.id.buttonSMSForAllShift:
                startActivity(new Intent(getActivity(), SMSForAllShift.class));
                break;
            case R.id.buttonOfficeStaffSMS:
                startActivity(new Intent(getActivity(), OfficeStaffSMS.class));
                break;
            case R.id.buttonBirthDayMessage:
                startActivity(new Intent(getActivity(), BirthDayMessage.class));
                break;
            case R.id.buttonSetBirthDayMessage:
                Toast.makeText(mContext, "I have no idea!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSMSAllClass:
                startActivity(new Intent(getActivity(), SMSForAllClass.class));
                break;
            case R.id.buttonSmsBranches:
                startActivity(new Intent(getActivity(), SMSAllBranches.class));
                break;
            case R.id.buttonManagingCommittee:
                startActivity(new Intent(getActivity(), ManagingCommittee.class));
                break;
            case R.id.buttonGovernBody:
                startActivity(new Intent(getActivity(), GoverningBody.class));
                break;
        }

    }

}
