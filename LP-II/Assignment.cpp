#include<bits/stdc++.h>
using namespace std;

class Node
{
private:
    int ver;
    Node *next;

public:
    Node()
    {
        ver = 0;
        next = NULL;
    }

    Node(int n)
    {
        ver = n;
        next = NULL;
    }
    friend class Graph;
};

class Graph
{
private:
    int vn;
    int en;
    Node **header;

public:
    Graph()
    {
        vn = 0;
        en = 0;
        header = NULL;
    }
    Graph(int v, int e)
    {
        vn = v;
        en = e;
        header = new Node *[v];
        for (int i = 0; i < v; i++)
        {
            header[i] = NULL;
        }
    }
    void input1();
    void BFS(int);
    void DFS(int);
    void display();
};

void Graph::input1()
{
    int s,d;
    for(int i=0;i<=en;i++)
    {
      cout<<"Enter Source vertex: ";
      cin>>s;
      cout<<"Enter destination vertex: ";
      cin>>d;
      Node*dnode = new Node(d);
      if(header[s]==NULL)
      {
        header[s]=dnode;
      }
      else
      {
        Node*temp=header[s];
        while(temp->next!=NULL)
        {
            temp=temp->next;
        }
        temp->next=dnode;
      }
    }
}


void Graph::BFS(int initial)
{
  queue<int>q;
  int *vis=new int[vn];
  for(int i=0;i<vn;i++)
  {
    vis[i]=0;
  }
  vis[initial]=1;
  q.push(initial);
  while(!q.empty())
  {
    int v= q.front();
    q.pop();
    cout<<v<<" ";
    Node*temp=header[v];
    while(temp!=NULL)
    {
        if(vis[temp->ver]==0)
        {
            q.push(temp->ver);
            vis[temp->ver]=1;
        }
        temp=temp->next;
    }
  }
  cout<<"\n";
}

void Graph::DFS(int initial)
{
  stack<int>s;
  int *vis=new int[vn];
  for(int i=0;i<vn;i++)
  {
    vis[i]=0;
  }
  vis[initial]=1;
  s.push(initial);
  while(!s.empty())
  {
    int v= s.top();
    s.pop();
    cout<<v<<" ";
    Node*temp=header[v];
    while(temp!=NULL)
    {
        if(vis[temp->ver]==0)
        {
            s.push(temp->ver);
            vis[temp->ver]=1;
        }
        temp=temp->next;
    }
  }
  cout<<"\n";
}


void Graph::display()
{
    for(int i=0;i<vn;i++)
    {
        Node*temp=header[i];
        cout<<i<<" ";
        while(temp!=NULL)
        {
           cout<<temp->ver<<"->";
           temp=temp->next;
        }
        cout<<"\n";
    }
}


int main()
{
  int v,e;
	int start;
	cout<<"Enter the no. of vertices: ";
	cin>>v;
	cout<<"Enter the no. of edges: ";
	cin>>e;
	int ch;
	Graph g(v,e);
	do
	{
        cout<<"--MENU--"<<"\n";
        cout<<"1.Input"<<"\n";
        cout<<"2.Display graph"<<"\n";
        cout<<"3.BFS"<<"\n";
        cout<<"4.DFS"<<"\n";
        cout<<"5.Exit"<<"\n";
        cout<<"Enter you choice\n";
		cin>>ch;
		switch(ch)
		{
		case 1:
			g.input1();
			break;
		case 2:
			g.display();
			break;
		case 3:
			cout<<"Enter the starting vertex: ";
			cin>>start;
			g.BFS(start);
			break;
		case 4:
			cout<<"Enter the starting vertex: ";
			cin>>start;
			g.DFS(start);
			break;
		case 5:
		    cout<<"Thank you! :)";
			break;
		}
	} while (ch!=5);
    return 0;
}
