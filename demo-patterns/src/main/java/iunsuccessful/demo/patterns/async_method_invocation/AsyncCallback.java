package iunsuccessful.demo.patterns.async_method_invocation;

import java.util.Optional;

/**
 * @author LiQZ on 2016/9/30.
 */
public interface AsyncCallback<T> {

    void onComplete(T result, Optional<Exception> ex);

}
