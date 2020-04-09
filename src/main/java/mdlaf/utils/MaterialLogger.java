/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/vincenzopalazzo
 */
public final class MaterialLogger {

    private static MaterialLogger SINGLETON;

    public static MaterialLogger getInstance(){
        if(SINGLETON == null){
            SINGLETON = new MaterialLogger();
        }
        return SINGLETON;
    }

    private Map<String, Logger> loggers = new HashMap<>();

    private MaterialLogger() {}

    public void debug(Class clazz, String message){
        //TODO implement this
        //TODO implement the if
        //System.out.println(clazz.getCanonicalName() + " " + message);
        Logger logger = this.getLogger(clazz);
        logger.debug(message);
    }

    public void info(Class clazz, String message){
        //TODO implement this method
        //TODO implement the if
        Logger logger = this.getLogger(clazz);
        logger.info(message);
    }

    public void error(Class clazz, String message){
        //TODO implement this method
        //TODO implement the if

        Logger logger = this.getLogger(clazz);
        logger.error(message);
    }

    private Logger generateLogger(Class clazz){
        if(clazz == null){
            //TODO implement the message error
            throw new IllegalArgumentException("Class is null");
        }
        Logger logger = LoggerFactory.getLogger(clazz.getCanonicalName());
        loggers.put(clazz.getCanonicalName(), logger);
        return logger;
    }

    private boolean isLoggerPresent(Class clazz){
        if(clazz == null){
            //TODO implement the message error
            throw new IllegalArgumentException("Class is null");
        }
        return loggers.containsKey(clazz.getCanonicalName());
    }

    private Logger getLogger(Class clazz){
        if(clazz == null ){
            //TODO implement the message error
            throw new IllegalArgumentException("Class is null");
        }
        Logger logger;
        if(isLoggerPresent(clazz)){
            logger = loggers.get(clazz.getCanonicalName());
        }else{
            logger = this.generateLogger(clazz);
        }

        return logger;
    }
}
