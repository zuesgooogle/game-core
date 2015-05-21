package com.simplegame.core.sync;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@author zeusgooogle
 *@date   2015-05-2 下午07:43:56
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sync {

    String component();
    
    int[] indexes();

}
