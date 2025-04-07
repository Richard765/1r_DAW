package ACT10_6D;

import java.util.ArrayList;

/** ArrayDeque: 'ArrayList' amb un número màxim d'elements prefixat
 public class ArraySet<E>(int maxSize) extends ArrayList<E> 
 * 
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArrayMax'
 *    2. maxSize - nombre màxim d'elements permesos
 */
public class ArrayDeque<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArrayDeque'

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        this.add(0,e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        super.add(0, element);
    }

    public boolean push(E e) {
        return add(e);
    }

    public E pop() {
        E lastElement = this.remove(0); 
        return lastElement;
    }
    
}