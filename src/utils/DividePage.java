package utils;

import java.util.List;

public class DividePage<E> {
	public List<E> getPage(List<E> list, int index, int size){
		return list.subList(index*size, index*size + size > list.size() ? list.size() : index*size+size);
	}
	
	public boolean hasNext(List<E> list, int index, int size) {
		return list.size()%size ==  0? index < list.size()/size : index <= list.size()/size;
	}
	
	public boolean hasPrev(List<E> list, int index, int size) {
		return index >= 0;
	}
}
