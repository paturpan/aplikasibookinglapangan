/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.model.event;
import ablf.entity.customer;
import ablf.model.AnggotaModel;
/**
 *
 * @author
 */
public interface customerListener {
    public void onChange(AnggotaModel model);
    
    public void onInsert(customer anggota);
    
    public void onUpdate(customer anggota);
    
    public void onDelete();
}
