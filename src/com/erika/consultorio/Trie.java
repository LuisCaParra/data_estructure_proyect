package com.erika.consultorio;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    // define size (all ascii table)
    private static final int CHAR_SIZE = 256;

    boolean isLeaf;
    List<Trie> children = null;

    // Constructor
    Trie() {
        isLeaf = false;
        children = new ArrayList<>();

        for (int i = 0; i < CHAR_SIZE; i++)
            children.add(null);
    }

    // Iterative function to insert string in trie
    public void insert(String key)
    {
        System.out.println("Ya esta registradx \"" + key + "\"");

        // start from root node
        Trie curr = this;

        // do for each character of the key
        for (int i = 0; i < key.length(); i++)
        {
            // create a new Trie node if path does not exist
            if (curr.children.get(key.charAt(i)) == null)
                curr.children.set(key.charAt(i), new Trie());

            // go to the next node
            curr = curr.children.get(key.charAt(i));
        }

        // mark current node as leaf
        curr.isLeaf = true;
    }

    // Iterative function to search a key in Trie.
    // Returns true if key is found in Trie
    // else returns false
    public boolean search(String key)
    {
        System.out.print("Buscando \"" + key + "\" : ");

        Trie curr = this;

        // do for each character of the key
        for (int i = 0; i < key.length(); i++)
        {
            // go to the next node
            curr = curr.children.get(key.charAt(i));

            // if string is invalid (reached end of path in Trie)
            if (curr == null)
                return false;
        }

        // return true if current node is a leaf node and
        // we reached end of the string
        return curr.isLeaf;
    }

}