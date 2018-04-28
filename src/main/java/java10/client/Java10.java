package java10.client;

import static io.reactivex.Observable.just;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.Optional;

public class Java10 implements EntryPoint {

    @Override public void onModuleLoad() {
        // this works 👍
        var anonymous = Optional.of(new Object() {String s = "hello world";});
        RootPanel.get().add(anonymous.map(o -> new Label(o.s)).get());

        // this doesn't work 👎
        var stream = just(1, 2, 3).map(n -> new Object() {String s = n + "!";});
        stream.forEach(o -> RootPanel.get().add(new Label(o.s)));
    }
}
