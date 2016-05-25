package in.vaksys.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dell980 on 5/25/2016.
 */
public class FragmentThree extends Fragment {

    private EventBus bus = EventBus.getDefault();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("FragmentThree","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FragmentThree","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        Log.e("FragmentThree","onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("FragmentThree","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("FragmentThree","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("FragmentThree","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("FragmentThree","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("FragmentThree","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("FragmentThree","onDestroyView");
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.e("FragmentThree","onDestroy");
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("FragmentThree","onDetach");
    }
    @Subscribe
    public void onEvent(MessageCar messageCar){
        Log.e("car datata",messageCar.getMsg());
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }


}