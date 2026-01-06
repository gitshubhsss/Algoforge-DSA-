#include <bits/st

char getMaxOccuringChar(string &s)
{
    //  code here

    unordered_map<char, int> mp;

    int maxFre = 0;

    for (int i = 0; i < s.size(); i++)
    {
        char ch = s[i];

        mp[ch]++;

        maxFre = max(maxFre, mp[ch]);
    }

    char ans = '\0';

    for (int i = 0; i < s.size(); i++)
    {
        char ch = s[i];

        if (mp[ch] == maxFre)
        {
        }
    }

    // https://leetcode.com/problems/intersection-of-two-arrays/
    vector<int> intersection(vector<int> & nums1, vector<int> & nums2)
    {

        unordered_set<int> se;

        for (int num : nums1)
        {
            se.insert(num);
        }

        vector<int> ans;

        for (int num : nums2)
        {
            if (se.find(num) != se.end())
            {
    
                ans.push_back(num);
                se.erase(num);

            }
        }

        return ans;
    }
}