#include <bits/stdc++.h>
using namespace std;

class Questions
{
public:
    bool isValid(string s)
    {
        stack<char> st;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s[i];

            if (ch == '(' || ch == '[' || ch == '{')
            {
                st.push(ch);
            }
            else if (ch == ')')
            {
                if (st.empty() || st.top() != '(')
                    return false;
                st.pop();
            }
            else if (ch == ']')
            {
                if (st.empty() || st.top() != '[')
                    return false;
                st.pop();
            }
            else if (ch == '}')
            {
                if (st.empty() || st.top() != '{')
                    return false;
                st.pop();
            }
        }

        return st.empty();
    }
};

/// moving from right to left in a reverse direction(https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
public:
vector<int> nextLargerElement(vector<int> &arr)
{
    int n = arr.size();

    // creating the vector
    vector<int> ngr(n, -1);

    stack<int> st;

    int i = n - 1;

    while (i >= 0)
    {
        int currEle = arr[i];

        while (st.size() > 0 && st.top() <= currEle)
        {
            st.pop();
        }

        if (st.size() != 0)
        {
            ngr[i] = st.top();
        }

        st.push(currEle);

        i--;
    }

    return ngr;
}

/// moving from left to right in a reverse direction(https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
// starting from 0th index

// we use the monotiic stack to store the indexes and we get the value on the basic of indexes
public:
vector<int> nextLargerElement(vector<int> &arr)
{
    int n = arr.size();

    // creating the vector
    vector<int> ngr(n, -1);

    stack<int> st;

    for (int i = 0; i < n; i++)
    {
        int currEle = arr[i];

        while (st.size() > 0 && arr[st.top()] < currEle)
        {
            ngr[st.top()] = currEle;
            st.pop();
        }

        st.push(i);
    }

    return ngr;
}

int main()
{
    Questions q;

    cout << q.isValid("()") << endl;     // 1
    cout << q.isValid("([{}])") << endl; // 1
    cout << q.isValid("(]") << endl;     // 0

    return 0;
}

// g++ Questions.cpp -o main ====>compile
// .\main.exe ====>run
