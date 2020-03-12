package com.example.lostandfoundpet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lostandfoundpet.dummy.DummyContent;
import com.example.lostandfoundpet.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p />
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PetFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";

    private OnListFragmentInteractionListener mListener;

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PetFragment newInstance(int columnCount) {
        PetFragment fragment = new PetFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PetFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            List<Pet> listOfPets = new ArrayList<>();


            String PACKAGE_NAME = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME2 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME3 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME4 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME5 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME6 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME7 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME8 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME9 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME10 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME11 = context.getApplicationContext().getPackageName();
            String PACKAGE_NAME12 = context.getApplicationContext().getPackageName();




            int imgId = getResources().getIdentifier(PACKAGE_NAME + ":drawable/" + "dedoggo", null, null);
            int imgId2 = getResources().getIdentifier(PACKAGE_NAME2 + ":drawable/" + "oggo", null, null);
            int imgId3 = getResources().getIdentifier(PACKAGE_NAME3 + ":drawable/" + "hal", null, null);
            int imgId4 = getResources().getIdentifier(PACKAGE_NAME4 + ":drawable/" + "isabela", null, null);
            int imgId5 = getResources().getIdentifier(PACKAGE_NAME5 + ":drawable/" + "kilo", null, null);
            int imgId6 = getResources().getIdentifier(PACKAGE_NAME6 + ":drawable/" + "momma", null, null);
            int imgId7 = getResources().getIdentifier(PACKAGE_NAME7 + ":drawable/" + "ripley", null, null);
            int imgId8 = getResources().getIdentifier(PACKAGE_NAME8 + ":drawable/" + "queendog", null, null);
            int imgId9 = getResources().getIdentifier(PACKAGE_NAME9 + ":drawable/" + "sea", null, null);
            int imgId10 = getResources().getIdentifier(PACKAGE_NAME10 + ":drawable/" + "ttr", null, null);
            int imgId11 = getResources().getIdentifier(PACKAGE_NAME11 + ":drawable/" + "toby", null, null);
            int imgId12 = getResources().getIdentifier(PACKAGE_NAME12 + ":drawable/" + "biggie_background", null, null);




            Drawable res = getResources().getDrawable(imgId);
            Drawable res2 = getResources().getDrawable(imgId2);
            Drawable res3 = getResources().getDrawable(imgId3);
            Drawable res4 = getResources().getDrawable(imgId4);
            Drawable res5 = getResources().getDrawable(imgId5);
            Drawable res6 = getResources().getDrawable(imgId6);
            Drawable res7 = getResources().getDrawable(imgId7);
            Drawable res8 = getResources().getDrawable(imgId8);
            Drawable res9 = getResources().getDrawable(imgId9);
            Drawable res10 = getResources().getDrawable(imgId10);
            Drawable res11 = getResources().getDrawable(imgId11);
            Drawable res12 = getResources().getDrawable(imgId12);



            listOfPets.add(new Pet("Tanner", "458998669", res, "Seattle"));
            listOfPets.add(new Pet("Tar", "329948484", res2, "Seattle"));
//            listOfPets.add(new Pet("elok",  "3349586958", res3, "Seattle"));
//            listOfPets.add(new Pet("remmy", "271737434", res4, "lawton"));
//            listOfPets.add(new Pet("luke", "0994845743", res5, "kirkland"));
            listOfPets.add(new Pet("eyan", "949573244", res6, "chakisha"));
//            listOfPets.add(new Pet("kkr", "119383947", res7, "edmund"));
//            listOfPets.add(new Pet("awk", "998483765", res8, "oklahoma"));
            listOfPets.add(new Pet("qwlk", "199846209", res9, "dallas"));
//            listOfPets.add(new Pet("seew", "654752098", res10, "houston"));
            listOfPets.add(new Pet("teef", "495399432", res11, "austin"));
            listOfPets.add(new Pet("bingo", "123456789", res12, "seattle"));


//            listOfPets.add(new Pet("Tanner", "dog", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.ytimg.com%2Fvi%2FMPV2METPeJU%2Fmaxresdefault.jpg&imgrefurl=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DMPV2METPeJU&tbnid=KypVIfrnXZbYeM&vet=12ahUKEwiamfX4ipToAhXhIjQIHTxFChQQMygAegUIARCNAg..i&docid=PesX8IHCvvYULM&w=1280&h=720&q=dog&ved=2ahUKEwiamfX4ipToAhXhIjQIHTxFChQQMygAegUIARCNAg", "Seattle"));
//            listOfPets.add(new Pet("Tanner", "dog", "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "Seattle"));
//            listOfPets.add(new Pet("Tanner", "dog", "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "Seattle"));
            recyclerView.setAdapter(new MyPetRecyclerViewAdapter(listOfPets, (MyPetRecyclerViewAdapter.OnListFragmentInteractionListener) mListener));

//            return view;
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {

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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
