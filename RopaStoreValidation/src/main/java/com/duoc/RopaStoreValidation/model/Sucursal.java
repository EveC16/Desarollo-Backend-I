@Entity
@Table(name = "SUCURSAL")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre; 

    public Sucursal(){

    }

    public Sucursal(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
   



}
