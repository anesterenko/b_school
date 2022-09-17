public class BloomFilter
{
    public int filter_len;
    public int filter;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        filter = 0;
    }

    public int hash1(String str1)
    {
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            result = (result * 17 + code) % filter_len;
        }
        return result;
    }


    public int hash2(String str1)
    {
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            result = (result * 223 + code) % filter_len;
        }
        return result;
    }

    public int getHashesBitMask(String str)
    {
        return (1 << hash1(str)) | (1 << hash2(str));
    }

    public void add(String str1)
    {
       filter = filter | getHashesBitMask(str1);
    }

    public boolean isValue(String str1)
    {
        int hashesBitMask = getHashesBitMask(str1);
        int masked = filter & hashesBitMask;
        return masked == hashesBitMask;
    }
}