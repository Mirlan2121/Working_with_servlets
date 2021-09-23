package com.company;

public class Element<E> {

    private E thisElement;
    private Element<E> nextElement;
    private Element<E> prevElement;

    public Element() {
    }

    public Element(E thisElement, Element<E> nextElement, Element<E> prevElement) {
        this.thisElement = thisElement;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
    }

    public E getThisElement() {
        return thisElement;
    }

    public void setThisElement(E thisElement) {
        this.thisElement = thisElement;
    }

    public Element<E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element<E> nextElement) {
        this.nextElement = nextElement;
    }

    public Element<E> getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(Element<E> prevElement) {
        this.prevElement = prevElement;
    }
}
