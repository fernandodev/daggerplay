package com.github.fernandodev.daggerplay;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by fernando on 10/13/14.
 */
@Qualifier @Retention(RUNTIME)
public @interface WithApplication {
}