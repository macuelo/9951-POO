package ui;

import service.ServicioUsuario;
import dao.UsuarioDAO;
import dao.JuegoDAO;
import dao.ReseñaDAO;
import model.Usuario;
import model.Juego;
import model.Reseña;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LauncherGUI extends JFrame {
    private ServicioUsuario servicioUsuario;
    private JuegoDAO juegoDAO;
    private ReseñaDAO reseñaDAO;

    public LauncherGUI() {
        this.servicioUsuario = new ServicioUsuario(new UsuarioDAO());
        this.juegoDAO = new JuegoDAO();
        this.reseñaDAO = new ReseñaDAO();

        setTitle("Launcher de Juegos (Sin Base de Datos)");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Launcher de Juegos", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setOpaque(true);
        title.setBackground(new Color(70, 130, 180));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        JButton btnRegistrarJuego = new JButton("Registrar Juego");
        JButton btnDejarReseña = new JButton("Dejar Reseña");
        JButton btnListarUsuarios = new JButton("Listar Usuarios");
        JButton btnListarJuegos = new JButton("Listar Juegos");
        JButton btnListarReseñas = new JButton("Listar Reseñas");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnRegistrarUsuario);
        panel.add(btnRegistrarJuego);
        panel.add(btnDejarReseña);
        panel.add(btnListarUsuarios);
        panel.add(btnListarJuegos);
        panel.add(btnListarReseñas);
        panel.add(btnSalir);

        add(panel, BorderLayout.CENTER);

        // Acciones de los botones
        btnRegistrarUsuario.addActionListener(e -> abrirVentanaRegistrarUsuario());
        btnRegistrarJuego.addActionListener(e -> abrirVentanaRegistrarJuego());
        btnDejarReseña.addActionListener(e -> abrirVentanaDejarReseña());
        btnListarUsuarios.addActionListener(e -> mostrarUsuarios());
        btnListarJuegos.addActionListener(e -> mostrarJuegos());
        btnListarReseñas.addActionListener(e -> mostrarReseñas());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void abrirVentanaRegistrarUsuario() {
        JDialog dialog = new JDialog(this, "Registrar Usuario", true);
        dialog.setSize(300, 150);
        dialog.setLayout(new GridLayout(4, 2));

        JTextField nombreField = new JTextField();
        JTextField emailField = new JTextField();

        dialog.add(new JLabel("Nombre:"));
        dialog.add(nombreField);
        dialog.add(new JLabel("Email:"));
        dialog.add(emailField);
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String nombre = nombreField.getText();
            String email = emailField.getText();
            if (nombre != null && !nombre.isEmpty() && email != null && !email.isEmpty()) {
                Usuario usuario = new Usuario(nombre, email);
                servicioUsuario.registrarUsuario(usuario);
                JOptionPane.showMessageDialog(dialog, "Usuario registrado con ID: " + usuario.getId());
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Por favor, completa todos los campos.");
            }
        });
        dialog.add(new JLabel());
        dialog.add(btnAceptar);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void abrirVentanaRegistrarJuego() {
        JDialog dialog = new JDialog(this, "Registrar Juego", true);
        dialog.setSize(300, 150);
        dialog.setLayout(new GridLayout(4, 2));

        JTextField tituloField = new JTextField();
        JTextField precioField = new JTextField();

        dialog.add(new JLabel("Título:"));
        dialog.add(tituloField);
        dialog.add(new JLabel("Precio:"));
        dialog.add(precioField);
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String titulo = tituloField.getText();
            String precioStr = precioField.getText();
            try {
                double precio = Double.parseDouble(precioStr);
                Juego juego = new Juego(titulo, precio);
                juegoDAO.insertar(juego);
                JOptionPane.showMessageDialog(dialog, "Juego registrado con ID: " + juego.getId());
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Precio inválido.");
            }
        });
        dialog.add(new JLabel());
        dialog.add(btnAceptar);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void abrirVentanaDejarReseña() {
        JDialog dialog = new JDialog(this, "Dejar Reseña", true);
        dialog.setSize(350, 200);
        dialog.setLayout(new GridLayout(6, 2));

        JTextField idUsuarioField = new JTextField();
        JTextField idJuegoField = new JTextField();
        JTextField puntuacionField = new JTextField();
        JTextArea comentarioArea = new JTextArea();

        dialog.add(new JLabel("ID Usuario:"));
        dialog.add(idUsuarioField);
        dialog.add(new JLabel("ID Juego:"));
        dialog.add(idJuegoField);
        dialog.add(new JLabel("Puntuación (1-5):"));
        dialog.add(puntuacionField);
        dialog.add(new JLabel("Comentario:"));
        dialog.add(new JScrollPane(comentarioArea));

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            try {
                int idUsuario = Integer.parseInt(idUsuarioField.getText());
                int idJuego = Integer.parseInt(idJuegoField.getText());
                int puntuacion = Integer.parseInt(puntuacionField.getText());
                String comentario = comentarioArea.getText();

                Usuario usuario = servicioUsuario.obtenerUsuario(idUsuario);
                Juego juego = juegoDAO.buscarPorId(idJuego);

                if (usuario == null || juego == null) {
                    JOptionPane.showMessageDialog(dialog, "Usuario o Juego no encontrado.");
                    return;
                }

                Reseña reseña = new Reseña(usuario, juego, puntuacion, comentario);
                reseñaDAO.insertar(reseña);
                JOptionPane.showMessageDialog(dialog, "Reseña agregada con ID: " + reseña.getId());
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Datos inválidos.");
            }
        });
        dialog.add(new JLabel());
        dialog.add(btnAceptar);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarUsuarios() {
        List<Usuario> usuarios = servicioUsuario.listarUsuarios();
        String[] columnas = {"ID", "Nombre", "Email"};
        Object[][] datos = new Object[usuarios.size()][3];

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            datos[i][0] = u.getId();
            datos[i][1] = u.getNombre();
            datos[i][2] = u.getEmail();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(this, scroll, "Usuarios", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarJuegos() {
        List<Juego> juegos = juegoDAO.listar();
        String[] columnas = {"ID", "Título", "Precio"};
        Object[][] datos = new Object[juegos.size()][3];

        for (int i = 0; i < juegos.size(); i++) {
            Juego j = juegos.get(i);
            datos[i][0] = j.getId();
            datos[i][1] = j.getTitulo();
            datos[i][2] = j.getPrecio();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(this, scroll, "Juegos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarReseñas() {
        List<Reseña> reseñas = reseñaDAO.listar();
        String[] columnas = {"ID", "Usuario", "Juego", "Puntuación", "Comentario"};
        Object[][] datos = new Object[reseñas.size()][5];

        for (int i = 0; i < reseñas.size(); i++) {
            Reseña r = reseñas.get(i);
            datos[i][0] = r.getId();
            datos[i][1] = r.getUsuario().getNombre();
            datos[i][2] = r.getJuego().getTitulo();
            datos[i][3] = r.getPuntuacion();
            datos[i][4] = r.getComentario();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(this, scroll, "Reseñas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LauncherGUI().setVisible(true);
        });
    }
}