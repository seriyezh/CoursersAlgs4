public class Board {
    
    private int[][] _blocks;
    
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks)           
    {
        this._blocks = blocks;
    }

    // board dimension N
    public int dimension()
    {
        return this._blocks.length;
    }
        
    // number of blocks out of place
    public int hamming()
    {
        
    }
    
    // sum of Manhattan distances between blocks and goal
    public int manhattan()
    {
        
    }
    
    // is this board the goal board?
    public boolean isGoal()
    {
        
    }
    
    // a boadr that is obtained by exchanging two adjacent blocks in the same row
    public Board twin()
    {
        
    }
    
    // does this board equal y?
    public boolean equals(Object y)
    {
        
    }
    
    // all neighboring boards
    public Iterable<Board> neighbors()
    {
        
    }
    
    // string representation of this board (in the output format specified below)
    public String toString()
    {
        
    }

    // unit tests (not graded)
    public static void main(String[] args)
    {
        
    }
}