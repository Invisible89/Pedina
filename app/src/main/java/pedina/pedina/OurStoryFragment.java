package pedina.pedina;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OurStoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OurStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OurStoryFragment extends Fragment {
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
     * @return A new instance of fragment OurStoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OurStoryFragment newInstance(String param1, String param2) {
        OurStoryFragment fragment = new OurStoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public OurStoryFragment() {
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
//        return inflater.inflate(R.layout.fragment_our_story, container, false);

        View rootView = inflater.inflate(R.layout.fragment_our_story, container, false);

        ImageView li_ee = (ImageView) rootView.findViewById(R.id.imageView_li_ee);
        ImageView li_lc = (ImageView) rootView.findViewById(R.id.imageView_li_lc);
        ImageView li_mc = (ImageView) rootView.findViewById(R.id.imageView_li_mc);
        ImageView li_ms = (ImageView) rootView.findViewById(R.id.imageView_li_ms);
        ImageView li_ac = (ImageView) rootView.findViewById(R.id.imageView_li_ac);
        ImageView li_st = (ImageView) rootView.findViewById(R.id.imageView_li_st);
        ImageView li_gb = (ImageView) rootView.findViewById(R.id.imageView_li_gb);
        SetLIListener(li_ee);
        SetLIListener(li_lc);
        SetLIListener(li_mc);
        SetLIListener(li_ms);
        SetLIListener(li_ac);
        SetLIListener(li_st);
        SetLIListener(li_gb);

        ImageView tw_ee = (ImageView) rootView.findViewById(R.id.imageView_tw_ee);
        ImageView tw_lc = (ImageView) rootView.findViewById(R.id.imageView_tw_lc);
        ImageView tw_mc = (ImageView) rootView.findViewById(R.id.imageView_tw_mc);
        ImageView tw_ms = (ImageView) rootView.findViewById(R.id.imageView_tw_ms);
        ImageView tw_ac = (ImageView) rootView.findViewById(R.id.imageView_tw_ac);
        ImageView tw_st = (ImageView) rootView.findViewById(R.id.imageView_tw_st);
        ImageView tw_gb = (ImageView) rootView.findViewById(R.id.imageView_tw_gb);
        SetTWListener(tw_ee);
        SetTWListener(tw_lc);
        SetTWListener(tw_mc);
        SetTWListener(tw_ms);
        SetTWListener(tw_ac);
        SetTWListener(tw_st);
        SetTWListener(tw_gb);

        return rootView;

    }

    public void SetTWListener(View image)
    {

        String username = "";

        switch (image.getId())
        {
            case R.id.imageView_tw_ee:
                username="epifely";
                break;
            case R.id.imageView_tw_lc:
                username="lucacarabetta";
                break;
            case R.id.imageView_tw_mc:
                username="michele__lt";
                break;
            case R.id.imageView_tw_ms:
                username="mirkosalvia";
                break;
            case R.id.imageView_tw_ac:
                username="alecapizzi1";
                break;
            case R.id.imageView_tw_st:
                username="silviato315";
                break;
            case R.id.imageView_tw_gb:
                username="gianlucablua";
                break;
        }

        final String finalUsername = username;
        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent twitterIntent = getOpenTwitterIntent(getActivity(), finalUsername);
                startActivity(twitterIntent);
            }
        });
    }

    public static Intent getOpenTwitterIntent(Context context, String username) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.twitter.android", 0); //Checks if TW is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?screen_name=" + username)); //Trys to make intent with TW's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/#!/" + username)); //catches and opens a url to the desired page
        }
    }

    public void SetLIListener(View image)
    {

        String url = "";

        switch (image.getId())
        {
            case R.id.imageView_li_ee:
                url="https://www.linkedin.com/pub/elisa-epifani/48/830/881";
                break;
            case R.id.imageView_li_lc:
                url="https://www.linkedin.com/profile/view?id=44658108";
                break;
            case R.id.imageView_li_mc:
                url="";
                break;
            case R.id.imageView_li_ms:
                url="https://www.linkedin.com/profile/view?id=179929358";
                break;
            case R.id.imageView_li_ac:
                url="https://www.linkedin.com/profile/view?id=415338175";
                break;
            case R.id.imageView_li_st:
                url="https://www.linkedin.com/profile/view?id=415328774";
                break;
            case R.id.imageView_li_gb:
                url="https://www.linkedin.com/profile/view?id=415449059";
                break;
        }

        final String finalUrl = url;
        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent linkedinIntent = getOpenLinkedinIntent(getActivity(), finalUrl);
                startActivity(linkedinIntent);
            }
        });
    }

    public static Intent getOpenLinkedinIntent(Context context, String url) {

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url)); //catches and opens a url to the desired page
    }

//    public static Intent getOpenFacebookIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("fb://profile/100003774634738")); //Trys to make intent with FB's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.facebook.com/aledat89")); //catches and opens a url to the desired page
//        }
//    }


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


}


