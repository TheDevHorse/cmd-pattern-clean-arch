# Command Pattern Clean Architecture

## Overview

This project demonstrates a **Clean Architecture** implementation using the **Command Pattern** to map `Status` values to their corresponding `UseCase` implementations. Each `Status` represents a possible state of an order, and a dedicated `UseCase` handles the business logic associated with that state.

---

## Core Features

1. **Dynamic Command Resolution**:
   - The controller dynamically resolves and executes a `UseCase` based on the order's `Status`.

2. **Scalable Design**:
   - Designed for scalability, making it easy to extend functionality with minimal effort.

3. **Separation of Concerns**:
   - The architecture separates controller logic, business rules, and domain modeling, ensuring clarity and maintainability.

---

## Status and UseCase Mapping

The `Status` enum defines the possible states of an order:

```java
public enum Status {
    IN_PROGRESS,  
    COMPLETED,    
    CANCELED;
}
```

Each `Status` is mapped to a corresponding `UseCase`:

- **`IN_PROGRESS`** → `InProgressOrderUseCase.java`
- **`COMPLETED`** → `CompletedOrderUseCase.java`
- **`CANCELED`** → `CanceledOrderUseCase.java`

---

## How It Works

1. **Controller**:
   - The controller delegates business logic to the appropriate `UseCase` based on the `OrderRequest.status`.

2. **Command Pattern**:
   - Each `UseCase` implements the `OrderUseCaseInputPort` interface, adhering to the dependency inversion principle.

3. **Dynamic Resolution**:
   - The `Status` determines which `UseCase` to invoke.

---

## Example: OrderController

The controller uses dynamic mapping to execute the appropriate `UseCase`:

```java
@PostMapping
public void createOrder(@RequestBody OrderRequest orderRequest) {
    orderUseCaseInputPortMap.get(orderRequest.status().name())
            .execute(mapToOrder(orderRequest));
}
```

---

## Example: CompletedOrderUseCase

The `CompletedOrderUseCase` processes orders with the `COMPLETED` status. It:

1. Retrieves the order from the repository.
2. Marks the order as completed.
3. Notifies an external system about the completed order.
4. Updates the order in the repository.

### Implementation

```java
@Component("COMPLETED")
public class CompletedOrderUseCase implements OrderUseCaseInputPort {

    private final OrderProxyOutputPort orderProxyOutputPort;
    private final OrderRepositoryOutputPort orderRepositoryOutputPort;

    public CompletedOrderUseCase(OrderRepositoryOutputPort orderRepositoryOutputPort, OrderProxyOutputPort orderProxyOutputPort) {
        this.orderRepositoryOutputPort = orderRepositoryOutputPort;
        this.orderProxyOutputPort = orderProxyOutputPort;
    }

    @Override
    public void execute(Order newOrder) {
        Order order = orderRepositoryOutputPort.getOrder(newOrder.orderId());
        order.completeOrder();
        orderProxyOutputPort.sendOrder(newOrder);
        orderRepositoryOutputPort.updateOrder(newOrder);
    }
}
```

---

## Benefits

1. **Flexibility**:
   - Easily extendable to support new statuses or business rules.

2. **Decoupling**:
   - The controller logic is independent of specific `UseCase` implementations.

3. **Maintainability**:
   - A clear separation of responsibilities simplifies debugging and future modifications.

---

This architecture ensures a scalable and robust implementation while adhering to the principles of **Clean Architecture** and the **Command Pattern**.
