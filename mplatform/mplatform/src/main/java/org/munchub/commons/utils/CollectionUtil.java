package org.munchub.commons.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class CollectionUtil
{
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];

    private CollectionUtil()
    {
    }

    public static boolean isEmpty(Collection<?> col)
    {
        return col == null || col.isEmpty();
    }

    public static boolean isEmpty(Object[] array)
    {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(Map<?, ?> map)
    {
        return map == null || map.isEmpty();
    }

    public static long[] toPrimitive(Collection<Long> collection)
    {
        return collection != null ? toPrimitive(collection.toArray(new Long[collection.size()])) : null;
    }

    public static long[] toPrimitive(final Long[] array)
    {
        if (array == null)
        {
            return null;
        }
        else if (array.length == 0)
        {
            return EMPTY_LONG_ARRAY;
        }
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++)
        {
            result[i] = array[i];
        }
        return result;
    }

    public static Long[] toObject(long[] array)
    {
        if (array == null)
        {
            return null;
        }
        else if (array.length == 0)
        {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        final Long[] result = new Long[array.length];
        for (int i = 0; i < array.length; i++)
        {
            result[i] = array[i];
        }
        return result;
    }

    public static Set<Long> set(long[] array)
    {
        if (array == null)
        {
            return null;
        }
        Set<Long> result = new TreeSet<Long>();
        for (long val : array)
        {
            result.add(val);
        }
        return result;
    }

    public static List<Long> list(long[] array)
    {
        if (array == null)
        {
            return null;
        }
        List<Long> result = new ArrayList<Long>();
        for (long val : array)
        {
            result.add(val);
        }
        return result;
    }

    public static Set<String> set(String[] array)
    {
        if (array == null)
        {
            return null;
        }
        Set<String> result = new TreeSet<String>();
        Collections.addAll(result, array);
        return result;
    }

    public static <T> T getFirst(List<T> list)
    {
        if (isEmpty(list))
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }
}