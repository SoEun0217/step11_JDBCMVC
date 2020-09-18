package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;
import kosta.mvc.model.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	private Properties proFile=DbUtil.getProFile();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardDTO> list=new ArrayList<BoardDTO>();//리턴값이 try블럭 밖에서 선언되어주어야 리턴하기편하다
		//그냥리턴되야할 것을 try밖에서 선언된다고 외워라
		String sql=proFile.getProperty("board.selectAll");
		try {
			
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();//select이기 때문에
			
			while(rs.next()) {
				BoardDTO dto=new BoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(dto);//리턴값은 하나만 가능하므로 모든 dto를 담을 바구니를 만드는것
			}
			//만약에 try밖에서 BoardDTO를 선언해주고 ex)BoardDTO dto=null;이렇게 하고 밑에 입력해주는것
			//이면 계속 같은 값 마지막꺼로 들어가게됨
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=proFile.getProperty("board.selectBySubject");
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(dto);
				}

			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		BoardDTO board=null;
		String sql=proFile.getProperty("board.selectByNo");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs=ps.executeQuery();
			while(rs.next()) {
				board=new BoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return board;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("board.insert");
		int result=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2,boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			result=ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("board.updateByNo");
		int result=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			result=ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("board.deleteByNo");
		int result=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	 
	public List<ReBoardDTO> reboardSelectByNo(int boardNO) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReBoardDTO>list=new ArrayList<ReBoardDTO>();
		String sql=proFile.getProperty("reboard.selectByNo");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,boardNO);
			rs=ps.executeQuery();
			while(rs.next()) {
				ReBoardDTO rDto=new ReBoardDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(rDto);
			}
			return list;
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	}

	@Override
	public int reBoardInsert(ReBoardDTO reBoard) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("reboard.insert");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, reBoard.getContent());
			ps.setInt(2, reBoard.getPriNo());
			result=ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 댓글 가져오기
	 * */
	@Override
	public BoardDTO replySelectByNo(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		BoardDTO board=null;
		String sql=proFile.getProperty("board.selectByNo");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				board=new BoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				
				//댓글정보 저장.
				List<ReBoardDTO>list=getReplyByBoardNo(con, boardNo);
				board.setReplyList(list);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return board;
	}

	/**
	 * 댓글가져오기
	 * 새로운 Connection이 아니라 원래있던 Connection을 받아온다!!
	 * */
	private List<ReBoardDTO> getReplyByBoardNo(Connection con,int boardNo)throws SQLException{
		PreparedStatement ps=null;
		String sql=proFile.getProperty("reply.selectByboardNo");
		List<ReBoardDTO>list=new ArrayList<ReBoardDTO>();
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ReBoardDTO board=new ReBoardDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(board);
			}
		}finally {//커넥션을 여기서 닫으면 안된다.
			DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}
	
	
	
}//클래스 끝
