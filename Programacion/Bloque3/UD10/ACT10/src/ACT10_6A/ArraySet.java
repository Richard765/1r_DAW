package ACT10_6A;

import java.util.ArrayList;

/** ArraySet: 'ArrayList' amb comportament de 'Set'
 * public class ArraySet<E> extends ArrayList<E> 
 * 
 * Tipus de paràmetre:
 *    1. E - el tipus d'elements en aquest 'ArraySet'
 */
public class ArraySet<E> extends ArrayList<E> {  // 'E' representa la classe dels elements de l''ArraySet'

    // Sobreescriptura d''add'
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) // 'contains()' té en compte el mètode 'equals' de la classe relacionada
            return super.add(e);
        else
            return false;
    }

}