package pedina.pedina;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrivoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrivoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrivoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PedinaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrivoFragment newInstance(String param1, String param2) {
        TrivoFragment fragment = new TrivoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TrivoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_trivo, container, false);

//        ImageView circle1 = (ImageView) rootView.findViewById(R.id.circle1);
//        ImageView circle2 = (ImageView) rootView.findViewById(R.id.circle2);
//        ImageView circle3 = (ImageView) rootView.findViewById(R.id.circle3);
//        ImageView circle4 = (ImageView) rootView.findViewById(R.id.circle4);
//        if (circle1!=null) SetCircleListener(circle1);
//        if (circle2!=null) SetCircleListener(circle2);
//        if (circle3!=null) SetCircleListener(circle3);
//        if (circle4!=null) SetCircleListener(circle4);

        return rootView;
    }

    public void SetCircleListener(View image)
    {
        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onCircleClicked(v);
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void onCircleClicked(View image)
    {
//        String text="";
//        String title="";
//        switch (image.getId())
//        {
//            case R.id.circle1:
//                text=getResources().getString(R.string.popup_gps);
//                title="GPS MODE";
//                break;
//            case R.id.circle2:
//                text=getResources().getString(R.string.popup_bluetooth);
//                title="BLUETOOTH";
//                break;
//            case R.id.circle3:
//                text=getResources().getString(R.string.popup_wireless);
//                title="SMART CHARGING";
//                break;
//            case R.id.circle4:
//                text=getResources().getString(R.string.popup_battery);
//                title="INNOVATIVE";
//                break;
//        }
//
//        final Dialog dialog = new Dialog(this.getActivity());
//        dialog.setContentView(R.layout.popup);
//        dialog.setTitle(title);
//        dialog.setCancelable(true);
//
//        TextView textView = (TextView) dialog.findViewById(R.id.text_popup);
//        textView.setText(text);
//
//        dialog.show();

    }

}
