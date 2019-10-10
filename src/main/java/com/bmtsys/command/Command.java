package com.bmtsys.command;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

public interface Command<E, T> {
	public T excute(E request);
}
