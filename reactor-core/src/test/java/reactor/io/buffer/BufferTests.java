package reactor.io.buffer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Sergey Shcherbakov
 */
public class BufferTests {

	@Test
	public void testAutoExpand() {
		
		int initial_small_size = Buffer.SMALL_BUFFER_SIZE;
		int initial_max_size = Buffer.MAX_BUFFER_SIZE;
		try {
			Buffer b = new Buffer();
			Buffer.SMALL_BUFFER_SIZE = 20;		// to speed up the test
			Buffer.MAX_BUFFER_SIZE = 100;		
			for(int i=0; i< Buffer.MAX_BUFFER_SIZE - Buffer.SMALL_BUFFER_SIZE; i++) {
				b.append((byte)0x1);
			}
		}
		finally {
			Buffer.SMALL_BUFFER_SIZE = initial_small_size;
			Buffer.MAX_BUFFER_SIZE = initial_max_size;		
		}
	}

}
