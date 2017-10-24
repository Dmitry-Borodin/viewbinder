package android.app;

import android.support.annotation.IdRes;
import android.view.View;

import kotlin.NotImplementedError;

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
public class Activity {

//	public View findViewById(@IdRes int id) {
//		throw new NotImplementedError("stub");
//	}

	public <T extends View> T findViewById(@IdRes int id) {
		throw new NotImplementedError("stub");
	}
}
