package in.vaksys.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dell980 on 5/25/2016.
 */
public class FragmentOne extends Fragment {

    private EventBus bus = EventBus.getDefault();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("FragmentOne","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FragmentOne","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        Log.e("FragmentOne","onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("FragmentOne","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("FragmentOne","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("FragmentOne","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("FragmentOne","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("FragmentOne","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("FragmentOne","onDestroyView");
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.e("FragmentOne","onDestroy");
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("FragmentOne","onDetach");
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
