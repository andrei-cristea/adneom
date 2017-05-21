package com.cristea.andrei.adneomlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility library to manipulate lists.
 * 
 * @author Andrei Cristea
 */
public final class ListUtils {

    /**
     * Private constructor
     */
    private ListUtils() {
	// NOP
    }

    /**
     * Returns a view of the original list "<b>{@code pList}</b>" represented by
     * a list of sublists, on which each sublist has at most
     * "<b>{@code pSize}</b>" elements.<br>
     * <br>
     * <u>Examples</u> :
     * <ul>
     * <li>partition([1,2,3,4,5], 2) return [ [1,2], [3,4], [5] ]
     * <li>partition([1,2,3,4,5], 3) return [ [1,2,3], [4,5] ]
     * <li>partition([1,2,3,4,5], 1) return [ [1], [2], [3], [4], [5] ]
     * </ul>
     * <u>Note</u> : The returned sublists contains Mutable or Immutable objects
     * depending of the input list (e.g. An input list of {@link String} will be
     * copied, an input list of {@link Date} will be referenced).<br>
     * <br>
     * 
     * @param pList
     *            The original list (not null).
     * @param pSize
     *            The maximum size of a sublist (greater than zero).
     * @return a new {@link List}
     * @throws IllegalArgumentException
     *             if "<b>{@code pList}</b>" is null or "<b>{@code pSize}</b>"
     *             is lower than 1.
     */
    public static List<List<Object>> partition(final List<? extends Object> pList, final int pSize) {

	if (pList == null || pSize < 1) {
	    throw new IllegalArgumentException("'pList' is null or 'pSize' is lower than 1");
	}

	List<List<Object>> result = new ArrayList<List<Object>>();
	List<Object> sublist = new ArrayList<Object>();
	int i = 0;
	for (Object e : pList) {
	    sublist.add(e);
	    i++;
	    if (i == pSize) {
		i = 0;
		result.add(sublist);
		sublist = new ArrayList<Object>();
	    }
	}
	if (i != 0) {
	    result.add(sublist);
	}
	return result;
    }
}
