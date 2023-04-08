package day30Dec3th;

import java.util.ArrayList;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class UniqueArrayList<Object> extends ArrayList<Object> {

    @Override
    public boolean add(Object element) {
        if (this.contains(element)) {
            return false;
        }
        return super.add(element);
    }

    @Override
    public void add(int index, Object element) {
        if (!this.contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (this.contains(element)) {
            return element;
        }
        return super.set(index, element);
    }
}
