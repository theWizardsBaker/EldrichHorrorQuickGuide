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

    public static final String GAME_PHASE = "com.justin_letourneau.eldrichhorrorquickguide.game_phase";
    ExpandableListView mActionsListView;
    TextView mTitle;
    TextView mSubtitle;

    public ActionPhaseFragment() {
        // Required empty public constructor
    }

    public static ActionPhaseFragment newInstance(ReferencePhaseModel.ReferencePhase gamePhase) {

        Bundle args = new Bundle();
        args.putParcelable(GAME_PHASE, gamePhase);

        ActionPhaseFragment fragment = new ActionPhaseFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // get the reference phase
        ReferencePhaseModel.ReferencePhase rp = getArguments().getParcelable(GAME_PHASE);

        // inflate the view
        View v = inflater.inflate(R.layout.fragment_action_phase, container, false);

        // set the title text
        mTitle = (TextView) v.findViewById(R.id.round_title_textView);
        mTitle.setText(rp.title);

        // set the subtitle text
        mSubtitle = (TextView) v.findViewById(R.id.round_summary_textView);
        mSubtitle.setText(rp.subtitle);


        // set our action list
        mActionsListView = (ExpandableListView) v.findViewById(R.id.round_actions_expandableListView);

        TurnActionsListAdapter adapter = new TurnActionsListAdapter(rp.actions);

        mActionsListView.setAdapter(adapter);

        return v;
    }

    public class TurnActionsListAdapter extends BaseExpandableListAdapter {

        private final ArrayList<ReferencePhaseModel.ReferencePhase.ReferenceAction> data;

        public TurnActionsListAdapter(ArrayList<ReferencePhaseModel.ReferencePhase.ReferenceAction> data){
            this.data = data;
        }

        @Override
        public int getGroupCount() {
            return data.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) { return data.get(groupPosition).detail.size(); }

        @Override
        public Object getGroup(int groupPosition) {
            return data.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) { return data.get(groupPosition).detail.get(childPosition);}

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
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.expandable_list_group_item, null);
            }
            // get the action
            ReferencePhaseModel.ReferencePhase.ReferenceAction action = data.get(groupPosition);
            // set the title
            TextView groupTitle = (TextView)convertView.findViewById(R.id.list_group_textView);
            groupTitle.setText(action.title);

            //set the subtitle
            TextView groupSubtitle = (TextView)convertView.findViewById(R.id.list_group_descr_textView);
            groupSubtitle.setText(action.description);

            // set the image
            Integer resource_image = action.image;
            if(resource_image != null){
                ImageView groupImage = (ImageView)convertView.findViewById(R.id.list_group_imageView);
                groupImage.setImageResource(resource_image);
            }
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.expandable_list_child_item, null);
            }
            String detail = data.get(groupPosition).detail.get(childPosition);

            TextView childDetail = (TextView) convertView.findViewById(R.id.list_child_descr_textView);
            childDetail.setText(detail);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
