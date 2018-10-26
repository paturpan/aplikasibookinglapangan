/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.error;

/**
 *
 * @author Penghuni Warnet
 */
public class bookingException extends Exception{
     public bookingException() {
    }

    /**
     * Constructs an instance of
     * <code>PinjamException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public bookingException(String msg) {
        super(msg);
    }
}

