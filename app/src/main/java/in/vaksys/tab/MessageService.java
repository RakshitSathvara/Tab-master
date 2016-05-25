package in.vaksys.tab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by patel on 25-05-2016.
 */
public class MessageService extends Service {
    private EventBus bus = EventBus.getDefault();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        sendMessage();
        return super.onStartCommand(intent, flags, startId);
    }

    // Send an Intent with an action named "custom-event-name". The Intent
    // sent should
    // be received by the ReceiverActivity.
    private void sendMessage() {
        Log.d("sender", "Broadcasting message");
//        Intent intent = new Intent("custom-event-name");
//        // You can also include some extra data.
//        intent.putExtra("message", "This is my message!");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

//        Intent insurance = new Intent("insurance");
//        insurance.putExtra("key", "car");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(insurance);

        bus.post(new MessageCar("data"));
        bus.post(new Messagebike("bike data"));


    }

}
