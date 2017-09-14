package tp.pr5.mv.cpu;

import java.util.ArrayList;

import tp.pr5.mv.controller.StackObserver;

public class OperandStack {
	private ArrayList<Integer> pila;
	private int length;
	private StackObserver stackO;

	public OperandStack() {
		pila = new ArrayList<Integer>();
		length = 0;
	}
	

	public int length() {
		return length;
	}
	public String toString(){
		String r = "";
		if (pila.size() == 0){
			return "<vacia>";
		}
		for (int i = 0; i < pila.size(); i++){
			r = r + pila.get (i) + " ";
			
		}
		return r;
	}

	public void push(Integer n) {
		pila.add(n);
		length++;
		if (stackO != null) {
			stackO.onPush(n);
		}
	}

	public Integer pop() {
		int aux = pila.get(pila.size() - 1);
		pila.remove(pila.size() - 1);
		length--;
		if (stackO != null) {
			stackO.onPop();
		}
		
		
		return aux;
		
	}
	
	public void addStackObserver (StackObserver so) {
		stackO = so;
	}
}
