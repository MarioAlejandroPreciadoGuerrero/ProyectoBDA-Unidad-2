/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;

/**
 *
 * @author USER
 */
public interface Repository <T> {
    List<T> getAll ();
    boolean save (T entity);
    boolean delete (Long id);
    T getByID (Long id);
}
