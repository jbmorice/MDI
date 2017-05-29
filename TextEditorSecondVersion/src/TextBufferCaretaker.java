import java.util.ArrayList;
import java.util.LinkedList;

public class TextBufferCaretaker {
    private ArrayList<TextBufferMemento> mementos;
    private int position;

    public TextBufferCaretaker() {
		super();
		this.mementos = new ArrayList<TextBufferMemento>();
		this.position = -1;
	}

	public void add(TextBufferMemento memento) {
		ArrayList<TextBufferMemento> tmp = new ArrayList<TextBufferMemento>();
		for(int i = 0; i < mementos.size(); i++) {
			tmp.add(mementos.get(i));
		}
		this.mementos = tmp;
		this.mementos.add(memento);
		this.position = this.mementos.size() - 1;
		System.out.println(this.position);
    }

	public TextBufferMemento getNext() {
        this.position++;
    	return this.mementos.get(this.position);        
    }
	
	public TextBufferMemento getPrevious() {
    	this.position--;
    	return this.mementos.get(this.position);
    }
	
	public boolean isNextPossible() {
		if(this.position < mementos.size() - 1)
			return true;
		return false;
	}
	
	// #FIXME décalage de 1
	public boolean isPreviousPossible() {
		if(this.position - 1 >= 0)
			return true;
		return false;
	}
}
