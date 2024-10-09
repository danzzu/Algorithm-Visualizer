public class Arrays<T> {
    private Object[] data;
    private int size, current;

    public Arrays(){
        this(2);
    }

    public Arrays(int size){
        this.size = size;
        this.current = 0;
        this.data = new Object[size];
    }

    private void sizeHandler(int current_size){
        if(!(current_size + 1 > size)) return ;
        // Create a new Array with double the size.
        // Doubling size each time is more efficient than reallocate each element
        
        Object[] replacement = new Object[size * 2];
        for(int i = 0; i < size; ++i){
            replacement[i] = this.data[i];
        }
        this.data = replacement;
        this.size = replacement.length;
    }

    public boolean add(T element){
        sizeHandler(this.current);
        this.data[current++] = element;
        return true;
    }

    public boolean addAll(Arrays<T> elements){
        for(int i = 0 ; i  < elements.size(); ++i){
            this.add(elements.get(i));
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        T value = (T) this.data[index];
        for(int i = index; i < this.current - 1; ++i){
            this.data[i] = this.data[i + 1];
        }
        --this.current;
        return value;
    }

    public boolean remove(T element){
        int i = 0;
        for(; i < this.size(); ++i){
            T find = (T) this.data[i];
            if(find == element){
                break;
            }
        }
        remove(i);
        return true;
    }

    public int size(){
        return this.current;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T)this.data[index];
    }

}
