package com.justin_letourneau.eldrichhorrorquickguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActionPhaseFragment extends Fragment {

    ExpandableListView mActionsListView;

    public ActionPhaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_action_phase, container, false);

        mActionsListView = (ExpandableListView) v.findViewById(R.id.round_actions_expandableListView);

        TurnActionsListAdapter adapter = new TurnActionsListAdapter(new ArrayList<TurnAction>());

        mActionsListView.setAdapter(adapter);

        return v;
    }

    public class TurnActionsListAdapter extends BaseExpandableListAdapter {

        ArrayList<TurnAction> data;

        public TurnActionsListAdapter(ArrayList<TurnAction> data){
            this.data = data;
        }

        @Override
        public int getGroupCount() {
            return data.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            try{
                return data.get(groupPosition).mActions.size();
            } catch (Exception e){
                return 0;
            }
        }

        @Override
        public Object getGroup(int groupPosition) {
            return data.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            try{
                return data.get(groupPosition).mActions;
            } catch (Exception e){
                return null;
            }
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView groupTitle = (TextView)convertView.findViewById(R.id.list_group_textView);
            groupTitle.setText(data.get(groupPosition).mTitle);
            Integer resource_image = data.get(groupPosition).mImageResource;
            if(resource_image != null){
                ImageView groupImage = (ImageView)convertView.findViewById(R.id.list_group_imageView);
                groupImage.setImageResource(resource_image);
            }
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
