package com.company;

public class MyList<E> {

    private Element<E> firstElem;
    private Element<E> lastElem;
    private int countElem = 0;

    public MyList() {
        this.firstElem = new Element<>();
        this.lastElem = new Element<>();

    }

    public Element<E> getFirstElem() {
        return firstElem;
    }

    public void setFirstElem(Element<E> firstElem) {
        this.firstElem = firstElem;
    }

    public Element<E> getLastElem() {
        return lastElem;
    }

    public void setLastElem(Element<E> lastElem) {
        this.lastElem = lastElem;
    }

    public int getSize() {
        return countElem;
    }

    public void setCountElem(int countElem) {
        this.countElem = countElem;
    }

    public E getIndexElement(int index){
        Element<E> getIndex = this.firstElem;
        for (int i = 0; i < index; i++) {
            getIndex = getIndex.getNextElement();
            
        }
        return getIndex.getThisElement();
    }

    public void addFirstElement(E firstElem){
        if (this.firstElem.getThisElement() != null){
            Element<E> nextElem = this.firstElem;
            this.firstElem = new Element<>(firstElem,nextElem,null);
            nextElem.setPrevElement(this.firstElem);
        }else {
            this.firstElem.setThisElement(firstElem);
            this.firstElem.setNextElement(this.lastElem);
            this.firstElem.setPrevElement(null);
        }
        this.countElem++;
    }
    public void addLastElement(E lastElem){
        if (this.firstElem.getThisElement() == null && this.lastElem.getThisElement() == null){
            addFirstElement(lastElem);
        }
        if (this.firstElem.getThisElement() != null && this.lastElem.getThisElement() == null){
            this.lastElem.setThisElement(lastElem);
            this.lastElem.setNextElement(null);
            this.lastElem.setPrevElement(firstElem);
            this.countElem++;
        }
        if (this.lastElem.getThisElement() != null){
            Element<E> prev = this.lastElem;
            this.lastElem = new Element<>(lastElem, null, prev);
            this.countElem++;
        }
    }
}
