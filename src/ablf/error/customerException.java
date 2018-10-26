/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.error;

/**
 *
 * @author 
 */
public class customerException extends Exception {
    /**
     * Creates a new instance of
     * <code>MemberException</code> without detail message.
     */
    public customerException() {
    }

    /**
     * Constructs an instance of
     * <code>AnggotaException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public customerException(String msg) {
        super(msg);
    }
}
