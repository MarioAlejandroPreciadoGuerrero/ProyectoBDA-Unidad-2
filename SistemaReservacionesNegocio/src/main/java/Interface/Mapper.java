/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author USER
 */
public interface Mapper <E, D> {
    E toEntity (D dto);
    
    D toDTO (E entity);
}
