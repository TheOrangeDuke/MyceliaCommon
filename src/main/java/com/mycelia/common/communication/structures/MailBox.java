package com.mycelia.common.communication.structures;

import java.util.LinkedList;

public class MailBox<T> {
	private LinkedList<T> in_queue = new LinkedList<T>();
	private LinkedList<T> out_queue = new LinkedList<T>();

	public MailBox() {
		// Do nothing
	}

	/**
	 * Adds a new Transmission to the outgoing queue This Transmission will be
	 * sent as soon as it becomes the next element
	 * 
	 * @param trans
	 */
	public void putInOutQueue(T trans) {
		out_queue.add(trans);
	}

	/**
	 * Adds a new Transmission to the head of the outgoing queue This
	 * Transmission is the next in line to be sent
	 * 
	 * @param trans
	 */
	public void putInOutQueueTop(T trans) {
		out_queue.add(0, trans);
	}
	
	/**
	 * Adds all the elements of the given list into the out queue
	 * @param out_list
	 */
	public void putAllInOutQueue(LinkedList<T> out_list){
		out_queue.addAll(out_list);
	}

	/**
	 * Adds the transmission to the incoming queue
	 * The transmission will be processed as soon as it becomes the next item that is being polled
	 * @param trans
	 */
	public void putInInQueue(T trans) {
		in_queue.add(trans);
	}
	
	/**
	 * Adds all the elements on the given list into the in queue
	 * @param in_list
	 */
	public void putAllInInQueue(LinkedList<T> in_list){
		in_queue.addAll(in_list);
	}
	
	/**
	 * Gets the next element that needs to be transmitted Return null if the
	 * queue is empty
	 * 
	 * @return transmission
	 */
	public T getFromOutQueue() {
		if (this.getOutQueueSize() == 0) {
			return null;
		} else {
			return out_queue.removeFirst();
		}
	}

	/**
	 * Returns the next available transmission that was received
	 * @return transmission
	 */
	public T getFromInQueue() {
		if (this.getInQueueSize() == 0) {
			return null;
		} else {
			return in_queue.removeFirst();
		}
	}

	/**
	 * Returns the size of the incoming queue
	 * @return integer
	 */
	public int getInQueueSize() {
		return in_queue.size();
	}

	/**
	 * Returns the size of the outgoing queue
	 * @return integer
	 */
	public int getOutQueueSize() {
		return out_queue.size();
	}
	
	/**
	 * Returns everything from the in queue of the Mailbox
	 * @return
	 */
	public LinkedList<T> getAllFromInQueue(){
		return in_queue;
	}
	
	/**
	 * Returns everything from the out queue of the Mailbox
	 * @return
	 */
	public LinkedList<T> getAllFromOutQueue(){
		return out_queue;
	}
}
