package com.bichel.datastructure;

/*
A Bloom filter is a space-efficient probabilistic data structure
that is used to test whether an element is a member of a set.
For example, checking availability of username is set membership problem,
where the set is the list of all registered username.
The price we pay for efficiency is that it is probabilistic in nature that means,
there might be some False Positive results.
False positive means, it might tell that given username is already taken,
but actually it’s not.
 */

public class BloomFilter {
}
/*
#include <bits/stdc++.h>
        #define ll long long
        using namespace std;

// hash 1
        int h1(string s, int arrSize)
        {
        ll int hash = 0;
        for (int i = 0; i < s.size(); i++)
        {
        hash = (hash + ((int)s[i]));
        hash = hash % arrSize;
        }
        return hash;
        }

// hash 2
        int h2(string s, int arrSize)
        {
        ll int hash = 1;
        for (int i = 0; i < s.size(); i++)
        {
        hash = hash + pow(19, i) * s[i];
        hash = hash % arrSize;
        }
        return hash % arrSize;
        }

// hash 3
        int h3(string s, int arrSize)
        {
        ll int hash = 7;
        for (int i = 0; i < s.size(); i++)
        {
        hash = (hash * 31 + s[i]) % arrSize;
        }
        return hash % arrSize;
        }

// hash 4
        int h4(string s, int arrSize)
        {
        ll int hash = 3;
        int p = 7;
        for (int i = 0; i < s.size(); i++) {
        hash += hash * 7 + s[0] * pow(p, i);
        hash = hash % arrSize;
        }
        return hash;
        }


// lookup operation
        bool lookup(bool* bitarray, int arrSize, string s)
        {
        int a = h1(s, arrSize);
        int b = h2(s, arrSize);
        int c = h3(s, arrSize);
        int d = h4(s, arrSize);

        if (bitarray[a] && bitarray[b] && bitarray
        && bitarray[d])
        return true;
        else
        return false;
        }

// insert operation
        void insert(bool* bitarray, int arrSize, string s)
        {
        // check if the element in already present or not
        if (lookup(bitarray, arrSize, s))
        cout << s << " is Probably already present" << endl;
        else
        {
        int a = h1(s, arrSize);
        int b = h2(s, arrSize);
        int c = h3(s, arrSize);
        int d = h4(s, arrSize);

        bitarray[a] = true;
        bitarray[b] = true;
        bitarray = true;
        bitarray[d] = true;

        cout << s << " inserted" << endl;
        }
        }

// Driver Code
        int main()
        {
        bool bitarray[100] = { false };
        int arrSize = 100;
        string sarray[33]
        = { "abound", "abounds",	 "abundance",
        "abundant", "accessible", "bloom",
        "blossom", "bolster",	 "bonny",
        "bonus", "bonuses",	 "coherent",
        "cohesive", "colorful",	 "comely",
        "comfort", "gems",		 "generosity",
        "generous", "generously", "genial",
        "bluff", "cheater",	 "hate",
        "war",	 "humanity",	 "racism",
        "hurt",	 "nuke",		 "gloomy",
        "facebook", "geeksforgeeks", "twitter" };
        for (int i = 0; i < 33; i++) {
        insert(bitarray, arrSize, sarray[i]);
        }
        return 0;
        }
*/
